import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Good Tests **/
   // Min Tests
   @Test public void minTest() {
      int[] a = {40, 91, 12, 2, 0};
      int expected = 0;
      int actual = Selector.min(a);
      Assert.assertEquals("minTest", expected, actual);
   }
   
   @Test public void oneMinTest() {
      int[] a = {2};
      int expected = 2;
      int actual = Selector.min(a);
      Assert.assertEquals("oneMinTest", expected, actual);
   }
    
    // Max Tests
   @Test public void maxTest() {
      int[] a = {40, 91, 12, 2, 0};
      int expected = 91;
      int actual = Selector.max(a);
      Assert.assertEquals("maxTest", expected, actual);
   }
   
   @Test public void oneMaxTest() {
      int[] a = {2};
      int expected = 2;
      int actual = Selector.max(a);
      Assert.assertEquals("oneMaxTest", expected, actual);
   }
   
    // kmin Tests
   @Test public void kminTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int expected = 40;
      int actual = Selector.kmin(a, 3);
      Assert.assertEquals("kminTest", expected, actual);
   }
   
   @Test public void last_kminTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int expected = 91;
      int actual = Selector.kmin(a, 6);
      Assert.assertEquals("last k min", expected, actual);
   }
   
   @Test public void one_kminTest() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.kmin(a, 1);
      Assert.assertEquals("single kminTest", expected, actual);
   }
   
   @Test public void duplicates_kminTest() {
      int[] a = {5, 5, 5};
      int expected = 5;
      int actual = Selector.kmin(a, 2);
      Assert.assertEquals("kminTest with same elements", expected, actual);
   }
   
    // kmax Tests
   @Test public void kmaxTest() {
      int[] a = {40, 91, 12, 2, 0, 91};
      int expected = 12;
      int actual = Selector.kmax(a, 3);
      Assert.assertEquals("kmaxTest", expected, actual);
   }
   
   @Test public void last_kmaxTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int expected = 0;
      int actual = Selector.kmin(a, 6);
      Assert.assertEquals("last k max", expected, actual);
   }
   
   @Test public void one_kmaxTest() {
      int[] a = {12};
      int expected = 12;
      int actual = Selector.kmax(a, 1);
      Assert.assertEquals("single kmaxTest", expected, actual);
   }
   
   @Test public void duplicates_kmaxTest() {
      int[] a = {5, 5, 5};
      int expected = 5;
      int actual = Selector.kmax(a, 3);
      Assert.assertEquals("kminTest with same elements", expected, actual);
   }
    
    // Range Tests
   @Test public void rangeTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int[] expected = {0, 2, 2};
      int[] actual = Selector.range(a, 0, 4);
      Assert.assertEquals("range test", expected, actual);
   }
   
   @Test public void mixupRangeTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int[] expected = {0, 2, 2};
      int[] actual = Selector.range(a, 4, 0);
      Assert.assertEquals("mixed up bounds range test", expected, actual);
   }
   
   @Test public void noRangeTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int expected = 0;
      int actual = Selector.range(a, 100, 400).length;
      Assert.assertEquals("no values in range test", expected, actual);
   }
   
   @Test public void singleRangeTest() {
      int[] a = {40};
      int[] expected = {40};
      int[] actual = Selector.range(a, 0, 40);
      Assert.assertEquals("single range test", expected, actual);
   }
       
       // Ceiling Tests  
   @Test public void ceilingTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int expected = 12;
      int actual = Selector.ceiling(a, 10);
      Assert.assertEquals("ceiling test", expected, actual);
   }
   
   @Test public void singleCeilingTest() {
      int[] a = {40};
      int expected = 40;
      int actual = Selector.ceiling(a, 10);
      Assert.assertEquals("single ceiling test", expected, actual);
   }
   
   // Floor Tests
   @Test public void floorTest() {
      int[] a = {40, 91, 12, 2, 2, 0};
      int expected = 12;
      int actual = Selector.floor(a, 14);
      Assert.assertEquals("floor test", expected, actual);
   }
   
   @Test public void singleFloorTest() {
      int[] a = {40};
      int expected = 40;
      int actual = Selector.floor(a, 50);
      Assert.assertEquals("single floor test", expected, actual);
   }
   
   /** Bad Tests **/
   // Null array tests
   @Test(expected=IllegalArgumentException.class)
   public void nullTest() {
      int[] a = null;
      int min = Selector.min(a);
      int max = Selector.max(a);
      int kmin = Selector.kmin(a, 1);
      int kmax = Selector.kmax(a, 1);
      int[] r = Selector.range(a, 1, 2);
      int c = Selector.ceiling(a, 1);
      int f = Selector.floor(a, 1);
   }
   
   // Empty array tests
   @Test(expected=IllegalArgumentException.class)
      public void emptyTest() {
      int[] a = new int[0];
      int min = Selector.min(a);
      int max = Selector.max(a);
      int kmin = Selector.kmin(a, 1);
      int kmax = Selector.kmax(a, 1);
      int[] r = Selector.range(a, 1, 2);
      int c = Selector.ceiling(a, 1);
      int f = Selector.floor(a, 1);
   }
   
   // Out of bounds tests
   @Test(expected=IllegalArgumentException.class)
      public void outOfBoundsTest() {
      int[] a = {1, 2, 3};
      int kmin = Selector.kmin(a, 5);
      int kmax = Selector.kmax(a, 5);
      int c = Selector.ceiling(a, 4);
      int f = Selector.floor(a, 0);
   }
}
