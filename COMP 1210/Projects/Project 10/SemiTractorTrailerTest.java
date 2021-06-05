import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Tests Semi Tractor Trailer class. 
 * Project 9- SemiTractorTrailerTest
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class SemiTractorTrailerTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests get axles. **/
   @Test public void getAxlesTest() {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
         
      Assert.assertEquals("getAxles test", 4, semi1.getAxles(), .001);
   }
   
   /** Tests set axles. **/
   @Test public void setAxlesTest() {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
      semi1.setAxles(5);
      
      Assert.assertEquals("setAxles test", 5, semi1.getAxles(), .001);
   }
   
   /** Tests useTax. **/
   @Test public void useTaxTest() {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
         
      Assert.assertEquals("semi useTax test", 3150, semi1.useTax(), .001);
   }
   
   /** Tests toString. **/
   @Test public void toStringTest() {
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
         
      Assert.assertTrue("toString test", semi1.toString().contains("Axle Tax"
         + " Rate: 0.02"));   
   }
}
