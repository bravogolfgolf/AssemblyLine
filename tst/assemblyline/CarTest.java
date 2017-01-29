package assemblyline;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class CarTest {

    @Test
    public void carShouldHaveNotHaveFrameBeforeAddingFrame(){
        Car car = new Car();
        assertFalse(car.hasFrame());
    }
}
