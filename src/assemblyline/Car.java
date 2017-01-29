package assemblyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

class Car {

    private static final int FACTOR = 1000;

    private int id;
    private Frame frame;
    private Engine engine;
    private List<Tire> tires = new ArrayList<>(4);
    private List<Seat> seats = new ArrayList<>(5);

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

    void build() throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future<Tire>> tireFutures = Collections.synchronizedList(new ArrayList<>(4));
        List<Future<Seat>> seatFutures = Collections.synchronizedList(new ArrayList<>(5));
        Future<Frame> frameFuture = es.submit(new Frame());
        Future<Engine> engineFuture = es.submit(new Engine());

        for (int i = 0; i < 4; i++)
            tireFutures.add(es.submit(new Tire()));

        for (int i = 0; i < 5; i++)
            seatFutures.add(es.submit(new Seat()));

        es.shutdown();

        addFrame(frameFuture.get());
        addEngine(engineFuture.get());
        for (Future<Tire> future : tireFutures)
            addTire(future.get());
        for (Future<Seat> future : seatFutures)
            addSeat(future.get());
    }

    @Override
    public String toString() {
        return String.format("Car: %d (Frame: %b; Engine: %b; Seats: %d; Tires: %d)",
                id, hasFrame(), hasEngine(), numberOfSeats(), numberOfTires());
    }

    boolean isComplete() {
        return hasFrame() && hasEngine() && (numberOfTires() == 4) && (numberOfSeats() == 5);
    }

    static class Frame implements Callable {
        @Override
        public Frame call() throws Exception {
            Thread.sleep(7 * FACTOR);
            return this;
        }
    }

    static class Engine implements Callable {
        @Override
        public Engine call() throws Exception {
            Thread.sleep(5 * FACTOR);
            return this;
        }
    }

    static class Tire implements Callable {
        @Override
        public Tire call() throws Exception {
            Thread.sleep(2 * FACTOR);
            return this;
        }
    }

    static class Seat implements Callable {
        @Override
        public Seat call() throws Exception {
            Thread.sleep(3 * FACTOR);
            return this;
        }
    }
}
