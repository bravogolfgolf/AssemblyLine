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
        car = new Car();
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
    public void competeCarHasRightNumberOfEachComponet() {
        car.build();
        assertTrue(carIsComplete());
    }

    private boolean carIsComplete() {
        return car.hasFrame() && car.hasEngine() && (car.numberOfTires() == 4) && (car.numberOfSeats() == 5);
    }
}
