import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Tests Truck class. 
 * Project 9- TruckTest
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class TruckTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests get tons. **/
   @Test public void getTonsTest() {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 30000, 
         false, 1.5);
      
      Assert.assertEquals("getTons test", 1.5, truck1.getTons(), .001);
   }
   
   /** Tests set tons. **/
   @Test public void setTonsTest() {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 30000, 
         false, 1.5);
      truck1.setTons(2.0);
      
      Assert.assertEquals("setTons test", 2.0, truck1.getTons(), .001);
   }
   
   /** Tests useTax. **/
   @Test public void useTaxTest() {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 30000, 
         false, 1.5);
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack", 40000, 
         true, 2.5);
      
      Assert.assertEquals("useTax test", 600, truck1.useTax(), .001);
      Assert.assertEquals("usetax test", 1600, truck2.useTax(), .001);
   }
   
   /** Tests toString. **/
   @Test public void toStringTest() {
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 30000, 
         false, 1.5);
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack", 40000, 
         true, 2.5);
         
      Assert.assertTrue("toString test", truck1.toString().contains("with"
         + " Tax Rate: 0.02"));
      Assert.assertTrue("toString test", truck2.toString().contains("with"
         + " Tax Rate: 0.01 Large Truck Tax Rate: 0.03"));
   }
}
