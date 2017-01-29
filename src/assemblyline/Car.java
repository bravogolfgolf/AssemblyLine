package assemblyline;

import java.util.ArrayList;
import java.util.List;

class Car {

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

    void addFrame() {
        frame = new Frame();
    }

    boolean hasEngine() {
        return engine != null;
    }

    void addEngine() {
        engine = new Engine();
    }

    int numberOfTires() {
        return tires.size();
    }

    void addTire() {
        tires.add(new Tire());
    }

    int numberOfSeats() {
        return seats.size();
    }

    void addSeat() {
        seats.add(new Seat());
    }

    void build() {
        addFrame();
        addEngine();
        for (int i = 0; i < 4; i++)
            addTire();
        for (int i = 0; i < 5; i++)
            addSeat();
    }

    @Override
    public String toString() {
        return String.format("Car: %d (Frame: %b; Engine: %b; Seats: %d; Tires: %d)",
                id, hasFrame(), hasEngine(), numberOfSeats(), numberOfTires());
    }

    boolean isComplete() {
        return hasFrame() && hasEngine() && (numberOfTires() == 4) && (numberOfSeats() == 5);
    }

    private class Frame {
    }

    private class Engine {
    }

    private class Tire {
    }

    private class Seat {
    }
}
