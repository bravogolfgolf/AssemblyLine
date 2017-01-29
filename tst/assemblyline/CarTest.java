package assemblyline;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
    }

    @Test
    public void carShouldHaveNotHaveFrameBeforeAddingFrame() {
        assertFalse(car.hasFrame());
    }

    @Test
    public void carShouldHaveOneFrameAfterAddingFrame() {
        car.addFrame();
        assertTrue(car.hasFrame());
    }

    @Test
    public void carShouldHaveNotHaveEngineBeforeAddingEngine() {
        assertFalse(car.hasEngine());
    }

    @Test
    public void carShouldHaveOneEngineAfterAddingEngine() {
        car.addEngine();
        assertTrue(car.hasEngine());
    }

    @Test
    public void carShouldHaveNoTiresBeforeAddingTires() {
        assertEquals(0, car.numberOfTires());
    }

    @Test
    public void carShouldHaveOneTireAfterAddingTire() {
        addThisManyTires(1);
        assertEquals(1, car.numberOfTires());
    }

    private void addThisManyTires(int number) {
        for (; number > 0; number--)
            car.addTire();
    }

    @Test
    public void carShouldHaveFourTiresAfterAddingFourTires() {
        addThisManyTires(4);
        assertEquals(4, car.numberOfTires());
    }

    @Test
    public void carShouldHaveNoSeatsBeforeAddingSeats() {
        assertEquals(0, car.numberOfSeats());
    }

    @Test
    public void carShouldHaveOneSeatAfterAddingSeat() {
        addThisManySeats(1);
        assertEquals(1, car.numberOfSeats());
    }

    private void addThisManySeats(int number) {
        for (; number > 0; number--)
            car.addSeat();
    }

    @Test
    public void carShouldHaveFiveSeatsAfterAddingFiveSeats() {
        addThisManySeats(5);
        assertEquals(5, car.numberOfSeats());
    }

    @Test
    public void competeCarHasRightNumberOfEachComponent() {
        car.build();
        assertTrue(car.isComplete());
    }

    @Test
    public void carToStringBeforeBuild() {
        assertEquals(car.toString(), "Car: 0 (Frame: false; Engine: false; Seats: 0; Tires: 0)");
    }

    @Test
    public void carToStringAfterBuild() {
        car.build();
        assertEquals(car.toString(), "Car: 0 (Frame: true; Engine: true; Seats: 5; Tires: 4)");
    }
}
