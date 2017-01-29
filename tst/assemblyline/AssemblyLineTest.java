package assemblyline;

import org.junit.Test;

public class AssemblyLineTest {

    @Test
    public void assemblyShouldBuildCarsInARow(){
        for (int i = 0; i < 3; i++) {
            Car car = new Car(i);
            car.build();
            System.out.println(car.toString());
        }
    }
}
