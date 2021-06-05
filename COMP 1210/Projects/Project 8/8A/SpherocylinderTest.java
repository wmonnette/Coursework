import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Tests Spherocylinder class. 
 * Project 8- Spherocylinder
 * @author: Wesley Monnette
 * @version: 11/3/2017 */
public class SpherocylinderTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests getters and setters. **/
   @Test public void getSetTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      Assert.assertEquals("getLabel test", "label", sc.getLabel());
      Assert.assertEquals("getRadius test", 1, sc.getRadius(), .001);
      Assert.assertEquals("getCylinderHeight test", 2, sc.getCylinderHeight(),
         .001);
      Assert.assertFalse("setLabel test", sc.setLabel(null));
      Assert.assertTrue("setLabel test", sc.setLabel("different label"));
      Assert.assertFalse("setRadius test", sc.setRadius(-1));
      Assert.assertTrue("setRadius test", sc.setRadius(5));
      Assert.assertFalse("setCylinderHeight test", sc.setCylinderHeight(-1));
      Assert.assertTrue("setCylinderHeight test", sc.setCylinderHeight(9));
   }
   
   /** Tests circumference. **/
   @Test public void circumferenceTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      Assert.assertEquals("circumference test", 2 * Math.PI * 1, 
         sc.circumference(), .001);
   }
   
   /** Tests surface area. **/
   @Test public void surfaceAreaTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      Assert.assertEquals("surface area test", 2 * Math.PI * 1 * (2 * 1 + 2), 
         sc.surfaceArea(), .001);
   }
   
   /** Tests volume. **/
   @Test public void volumeTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      Assert.assertEquals("volume test", 
         Math.PI * Math.pow(1, 2) * ((4.0 / 3) * 1 + 2), sc.volume(), .001);
   }
   
   /** Tests toString. **/
   @Test public void toStringTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      Assert.assertTrue("toString test", 
         sc.toString().contains("with radius 1"));   
   }
   
   /** Tests getCount and resetCount. **/
   @Test public void getResetCountTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      sc.resetCount();
      Spherocylinder scA = new Spherocylinder("label", 1, 2);
      Assert.assertEquals("getCount test", 1, scA.getCount());
   }
   
   /** Tests equals. **/
   @Test public void equalsTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      String s = "";
      Spherocylinder scA = sc;
      Assert.assertFalse("equals test", sc.equals(s));
      Assert.assertTrue("equals test", sc.equals(scA));
   }
   
   /** Tests hashCode. **/
   @Test public void hashCodeTest() {
      Spherocylinder sc = new Spherocylinder("label", 1, 2);
      Assert.assertEquals("hashCode test", 0, sc.hashCode());
   }
}
