import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Tests main method. 
 * Project 9- VehiclePart1Test
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class VehiclesPart1Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests number of vehicles created. **/
   @Test public void numberVehiclesTest() {
      VehiclesPart1 vp1 = new VehiclesPart1();
      Vehicle.resetVehicleCount();
      VehiclesPart1.main(null);
      Assert.assertEquals("Vehicle.vehicleCount should be 8. ",
         8, Vehicle.getVehicleCount());
   }
}
