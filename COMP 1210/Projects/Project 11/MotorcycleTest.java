import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Tests Motorcycle class. 
 * Project 9- MotorcycleTest
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class MotorcycleTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests get engine size. **/
   @Test public void getEngineSizeTest() {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 750);
   
      Assert.assertEquals("engine size test", 750, bike1.getEngineSize(),
         .001);
   }
   
   /** Tests set engine size. **/
   @Test public void setEngineSizeTest() {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      bike1.setEngineSize(800);
      Assert.assertEquals("engine size test", 800, bike1.getEngineSize(),
         .001);
   }
   
   /** Tests use tax. **/
   @Test public void useTaxTest() {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 750);
      Motorcycle bike2 = new Motorcycle("Me", "Ninja", 5000, true, 350);
      Motorcycle bike3 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, true, 750);
      Motorcycle bike4 = new Motorcycle("Me", "Ninja", 5000, false, 350);
   
      Assert.assertEquals("big engine, non altFuel test", 280, bike1.useTax(),
         .001);
      Assert.assertEquals("small engine, altFuel test", 12.5, bike2.useTax(),
         .001);
      Assert.assertEquals("big engine, altFuel test", 245, bike3.useTax(),
         .001);
      Assert.assertEquals("small engine, non altFuel test", 25, bike4.useTax(),
         .001);
   }
   
   /** Tests toString. **/
   @Test public void toStringTest() {
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", "Sportster", 14000, 
         false, 750);
      Motorcycle bike2 = new Motorcycle("Me", "Ninja", 5000, true, 350);
      Motorcycle bike3 = new Motorcycle("Brando, Marlon", "Sportster", 14000, 
         true, 750);
      
      Assert.assertTrue("big engine non altFuel test", bike1.toString().
         contains("with Tax Rate: 0.005 Large Bike Tax Rate: 0.015"));
      Assert.assertTrue("small engine altFuel test", bike2.toString().contains(
         "with Tax Rate: 0.0025"));
   }
}
