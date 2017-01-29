package assemblyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Car {

    private static final int FACTOR = 1000;
    private static final int REQUIRED_NUMBER_OF_TIRES = 4;
    private static final int REQUIRED_NUMBER_OF_SEATS = 5;
    private static final int THREAD_POOL_LIMIT = 3;
    private static final String NEW_LINE = System.lineSeparator();

    private final int id;
    private Engine engine;
    private Frame frame;
    private final List<Tire> tires = new ArrayList<>(REQUIRED_NUMBER_OF_TIRES);
    private final List<Seat> seats = new ArrayList<>(REQUIRED_NUMBER_OF_SEATS);

    Car(int id) {
        this.id = id;
    }

    boolean hasFrame() {
        return frame != null;
    }

    void addFrame(Frame frame) {
        this.frame = frame;
    }

    boolean hasEngine() {
        return engine != null;
    }

    void addEngine(Engine engine) {
        this.engine = engine;
    }

    int numberOfTires() {
        return tires.size();
    }

    void addTire(Tire tire) {
        tires.add(tire);
    }

    int numberOfSeats() {
        return seats.size();
    }

    void addSeat(Seat seat) {
        seats.add(seat);
    }

    void build() {

        ExecutorService es = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);
        List<Future<Tire>> tireFutures = Collections.synchronizedList(new ArrayList<>(REQUIRED_NUMBER_OF_TIRES));
        List<Future<Seat>> seatFutures = Collections.synchronizedList(new ArrayList<>(REQUIRED_NUMBER_OF_SEATS));

        Future<Engine> engineFuture = es.submit(() -> {
            buildTime(7);
            buildMessage("engine");
            return new Engine();
        });

        Future<Frame> frameFuture = es.submit(() -> {
            buildTime(5);
            buildMessage("frame");
            return new Frame();
        });

        for (int i = 0; i < REQUIRED_NUMBER_OF_SEATS; i++)
            seatFutures.add(es.submit(() -> {
                buildTime(3);
                buildMessage("seat");
                return new Seat();
            }));

        for (int i = 0; i < REQUIRED_NUMBER_OF_TIRES; i++)
            tireFutures.add(es.submit(() -> {
                buildTime(2);
                buildMessage("tire");
                return new Tire();
            }));

        es.shutdown();

        try {
            addFrame(frameFuture.get());
            addEngine(engineFuture.get());
            for (Future<Tire> future : tireFutures)
                addTire(future.get());
            for (Future<Seat> future : seatFutures)
                addSeat(future.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void buildTime(int millis) throws InterruptedException {
        Thread.sleep(millis * FACTOR);
    }

    private void buildMessage(String label) {
        System.out.format("Building %s with %s%s", label, Thread.currentThread().getName(), NEW_LINE);
    }

    @Override
    public String toString() {
        return String.format("Car: %d (Frame: %b; Engine: %b; Seats: %d; Tires: %d)",
                id, hasFrame(), hasEngine(), numberOfSeats(), numberOfTires());
    }

    boolean isComplete() {
        return hasFrame() &&
                hasEngine() &&
                (numberOfTires() == REQUIRED_NUMBER_OF_TIRES) &&
                (numberOfSeats() == REQUIRED_NUMBER_OF_SEATS);
    }

    static class Frame {
    }

    static class Engine {
    }

    static class Tire {
    }

    static class Seat {
    }
}
