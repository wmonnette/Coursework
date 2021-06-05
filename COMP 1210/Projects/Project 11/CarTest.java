import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Tests Car class. 
 * Project 9- CarTest
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class CarTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests useTax. **/
   @Test public void useTaxTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 110000, 
         false);
      Car car4 = new Car("Smith, Sam", "2015 Mercedes-Benz Coupe", 110000, 
         true);
         
      Assert.assertEquals("non altFuel non luxury car test", 220, 
         car1.useTax(), .001);
      Assert.assertEquals("altFuel non luxury car test", 110, car2.useTax(),
         .001);
      Assert.assertEquals("non altFuel luxury car test", 3300, car3.useTax(), 
         .001);
      Assert.assertEquals("altFuel luxury car test", 2750, car4.useTax(),
         .001);
   }
   
   /** Tests toString. **/
   @Test public void toStringTest() {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 110000, 
         false);
      Car car4 = new Car("Smith, Sam", "2015 Mercedes-Benz Coupe", 110000, 
         true);
         
      Assert.assertTrue("non altFuel non luxury car test", car1.toString().
         contains("with Tax Rate: 0.01"));
      Assert.assertTrue("altFuel non luxury car test", car2.toString().
         contains("with Tax Rate: 0.005"));
      Assert.assertTrue("non altFuel luxury car test", car3.toString().
         contains("with Tax Rate: 0.01 Luxury Tax Rate: 0.02"));
      Assert.assertTrue("altFuel luxury car test", car4.toString().
         contains("with Tax Rate: 0.005 Luxury Tax Rate: 0.02"));
   }
}