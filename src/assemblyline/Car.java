package assemblyline;

class Car {

    private Frame frame;
    private Engine engine;

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

    private static class Frame {

    }

    private static class Engine {

    }
}
