package assemblyline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {

    @Test
    public void carShouldHaveNotHaveFrameBeforeAddingFrame(){
        Car car = new Car();
        assertEquals(0,car.frameCount());
    }
}
