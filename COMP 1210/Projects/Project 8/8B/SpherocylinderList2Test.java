import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

/** Tests Spherocylinder class. 
 * Project 8B- SpherocylinderList
 * @author: Wesley Monnette
 * @version: 11/10/2017 */
public class SpherocylinderList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Tests getters. **/
   @Test public void gettersTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      Assert.assertEquals("getName test", "label", scList.getName());
      Assert.assertArrayEquals("getList test", sList, scList.getList());
   }
   
   /** Tests number of spherocylinders. **/
   @Test public void numberOfSpherocylindersTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      Assert.assertEquals("numberOfSpherocylinders test", 3, 
         scList.numberOfSpherocylinders(), .001);
   }
   
   /** Tests total surface area. **/
   @Test public void totalSurfaceAreaTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      Spherocylinder sc = new Spherocylinder("label", 3, 4);
      sList[0] = s;
      sList[1] = sc;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 2);
      Assert.assertEquals("totalSurfaceArea test", (s.surfaceArea() 
         + sc.surfaceArea()), scList.totalSurfaceArea(), .001);
   }
   
   /** Tests total area. **/
   @Test public void totalVolumeTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      Spherocylinder sc = new Spherocylinder("label", 3, 4);
      sList[0] = s;
      sList[1] = sc;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 2);
      Assert.assertEquals("totalVolume test", (s.volume() + sc.volume()), 
         scList.totalVolume(), .001);
   }
   
   /** Tests average surface area. **/
   @Test public void averageSurfaceAreaTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      Spherocylinder sc = new Spherocylinder("label", 3, 4);
      sList[0] = s;
      sList[1] = sc;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 2);
      Assert.assertEquals("averageSurfaceArea test", (s.surfaceArea() 
         + sc.surfaceArea()) / 2, scList.averageSurfaceArea(), .001);
   }
   
   /** Tests average surface area if zero. **/
   @Test public void averageSurfaceAreaTestZero() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      Spherocylinder sc = new Spherocylinder("label", 3, 4);
      sList[0] = s;
      sList[1] = sc;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 0);
      Assert.assertEquals("averageSurfaceArea test", 0, 
         scList.averageSurfaceArea(), .001);
   }
   
   /** Tests average volume. **/
   @Test public void averageVolumeTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      Spherocylinder sc = new Spherocylinder("label", 3, 4);
      sList[0] = s;
      sList[1] = sc;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 2);
      Assert.assertEquals("averageVolume test", (s.volume() + sc.volume()) / 2,
         scList.averageVolume(), .001);
   }
   
   /** Tests average volume if zero. **/
   @Test public void averageVolumeTestZero() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      Spherocylinder sc = new Spherocylinder("label", 3, 4);
      sList[0] = s;
      sList[1] = sc;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 0);
      Assert.assertEquals("averageVolume test", 0,
         scList.averageVolume(), .001);
   }
   
   /** Tests output. **/
   @Test public void toStringTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      sList[0] = s;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      Assert.assertTrue("toString test", scList.toString().contains(
         "with radius 1.0 and cylinder height 2.0 has"));
   }
   
   /** Tests summary info. **/
   @Test public void summaryInfoTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s = new Spherocylinder("label", 1, 2);
      sList[0] = s;
      SpherocylinderList2 scList = new SpherocylinderList2("spherocylinders", 
         sList, 1);
      Assert.assertTrue("summaryInfo test", scList.summaryInfo().contains(
         "Number of Spherocylinders: 1"));
   }
   
   /** Tests read file. 
    * @throws IOException if no file found **/
   @Test public void readFileTest() throws IOException {
      Spherocylinder [] sList = new Spherocylinder[100];
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 1);
      scList.readFile("spherocylinder_data_1.txt");
      Assert.assertEquals("readFile test", "Spherocylinder Test List", 
         scList.getName());
   }
   
   /** Tests add spherocylinder. **/
   @Test public void addSpherocylinderTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 0);
      scList.addSpherocylinder("sc", 1, 2);
      Assert.assertEquals("addSpherocylinder test", 1,
         scList.numberOfSpherocylinders(), .001);
   }
   
   /** Tests find spherocylinder. **/
   @Test public void findSpherocylinderTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 1, 2);
      Spherocylinder s3 = new Spherocylinder("sc3", 1, 2);
      sList[0] = s1;
      sList[1] = s2;
      sList[2] = s3;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      Assert.assertEquals("findSpherocylinder test", s2,
         scList.findSpherocylinder("sc2"));
   }
   
   /** Tests delete spherocylinder. **/
   @Test public void deleteSpherocylinderTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 1, 2);
      Spherocylinder s3 = new Spherocylinder("sc3", 1, 2);
      sList[0] = s1;
      sList[1] = s2;
      sList[2] = s3;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      scList.deleteSpherocylinder("sc2");
      Assert.assertEquals("deleteSpherocylinder test", null, sList[2]);
   }
   
   /** Tests edit spherocylinder. **/
   @Test public void editSpherocylinderTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      Spherocylinder s3 = new Spherocylinder("sc3", 5, 6);
      sList[0] = s1;
      sList[1] = s2;
      sList[2] = s3;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      scList.editSpherocylinder("sc2", 7, 8);
      Assert.assertEquals("editSpherocylinder test", 7,
         sList[1].getRadius(), .001);
   }
   
   /** Tests find smallest radius of spherocylinders. **/
   @Test public void findSpherocylinderWithShortestRadiusTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      Spherocylinder s3 = new Spherocylinder("sc3", 5, 6);
      sList[0] = s1;
      sList[1] = s2;
      sList[2] = s3;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      Spherocylinder s4 = scList.findSpherocylinderWithShortestRadius();
      Assert.assertEquals("findSpherocylinderWithShortestRadius test", s1, s4);
   }
   
   /** Tests find smallest radius of spherocylinders if null. **/
   @Test public void findSpherocylinderWithShortestRadiusTestNegative() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      Spherocylinder s3 = new Spherocylinder("sc3", 5, 6);
      sList[0] = s1;
      sList[1] = s2;
      sList[2] = s3;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 0);
      Spherocylinder s4 = scList.findSpherocylinderWithShortestRadius();
      Assert.assertEquals("findSpherocylinderWithShortestRadius test", null,
         s4);
   }
   
   /** Tests find longest radius of spherocylinders. **/
   @Test public void findSpherocylinderWithLongestRadiusTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      Spherocylinder s3 = new Spherocylinder("sc3", 5, 6);
      sList[0] = s1;
      sList[1] = s2;
      sList[2] = s3;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 3);
      Spherocylinder s4 = scList.findSpherocylinderWithLongestRadius();
      Assert.assertEquals("findSpherocylinderWithLongestRadius test", s3, s4);
   }
   
   /** Tests find longest radius of spherocylinders if null. **/
   @Test public void findSpherocylinderWithLongestRadiusTestNegative() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      Spherocylinder s3 = new Spherocylinder("sc3", 5, 6);
      sList[0] = s1;
      sList[1] = s2;
      sList[2] = s3;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 0);
      Spherocylinder s4 = scList.findSpherocylinderWithLongestRadius();
      Assert.assertEquals("findSpherocylinderWithLongestRadius test", null,
         s4);
   }
   
   /** Tests find smallest volume of spherocylinders. **/
   @Test public void findSpherocylinderWithSmallestVolumeTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      sList[0] = s1;
      sList[1] = s2;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 2);
      Spherocylinder s3 = scList.findSpherocylinderWithSmallestVolume();
      Assert.assertEquals("findSpherocylinderWithSmallestVolume test", s1, s3);
   }
   
   /** Tests find smallest volume of spherocylinders if null. **/
   @Test public void findSpherocylinderWithSmallestVolumeTestNegative() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      sList[0] = s1;
      sList[1] = s2;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 0);
      Spherocylinder s3 = scList.findSpherocylinderWithSmallestVolume();
      Assert.assertEquals("findSpherocylinderWithSmallestVolume test", null,
         s3);
   }
   
   /** Tests find largest volume of spherocylinders. **/
   @Test public void findSpherocylinderWithLargestVolumeTest() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      sList[0] = s1;
      sList[1] = s2;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 2);
      Spherocylinder s3 = scList.findSpherocylinderWithLargestVolume();
      Assert.assertEquals("findSpherocylinderWithSmallestVolume test", s2, s3);
   }
   
   /** Tests find largest volume of spherocylinders if null. **/
   @Test public void findSpherocylinderWithLargestVolumeTestNegative() {
      Spherocylinder [] sList = new Spherocylinder[100];
      Spherocylinder s1 = new Spherocylinder("sc1", 1, 2);
      Spherocylinder s2 = new Spherocylinder("sc2", 3, 4);
      sList[0] = s1;
      sList[1] = s2;
      SpherocylinderList2 scList = new SpherocylinderList2("label", sList, 0);
      Spherocylinder s3 = scList.findSpherocylinderWithLargestVolume();
      Assert.assertEquals("findSpherocylinderWithSmallestVolume test", null,
         s3);
   }
}
