package assemblyline;

class Car {

    private Frame frame;

    boolean hasFrame() {
        return frame != null;
    }

    void addFrame() {
        frame = new Frame();
    }

    private static class Frame {

    }
}
