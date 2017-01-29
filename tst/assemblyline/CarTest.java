package assemblyline;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void carShouldHaveNotHaveFrameBeforeAddingFrame(){
        assertFalse(car.hasFrame());
    }

    @Test
    public void carShouldHaveOneFrameAfterAddingFrame(){
        car.addFrame();
        assertTrue(car.hasFrame());
    }
}
