package assemblyline;

import org.junit.Test;

public class AssemblyLineTest {

    @Test
    public void assemblyShouldBuildCarsInARow() throws Exception {
        for (int i = 0; i < 1; i++) {
            Car car = new Car(i);
            car.build();
            System.out.println(car.toString());
        }
    }
}
