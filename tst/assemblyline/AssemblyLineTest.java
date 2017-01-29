package assemblyline;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AssemblyLineTest {

    @Test
    public void assemblyShouldBuildCarsInARow() {
        for (int i = 0; i < 1; i++) {
            Car car = new Car(i);
            car.build();
            System.out.println(car.toString());
            assertTrue(car.isComplete());
        }
    }
}
