package assemblyline;

import java.util.ArrayList;
import java.util.List;

class Car {

    private Frame frame;
    private Engine engine;
    private List<Tire> tires = new ArrayList<>();

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

    private class Frame {

    }

    private class Engine {

    }

    private class Tire {
    }
}
