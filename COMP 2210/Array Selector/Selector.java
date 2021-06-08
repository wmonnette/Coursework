import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Wesley Monnette (wjm0017@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  Jan 23 2019
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }

   /** Counts copies of array values.
    * @param a array to count
    * @return count the number of copies
    */
   public static int countCopies(int[] a) {
      int copies = 0;
      int b [] = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      
      int i = 1;
      for (int e : b) {
         if(!(i < b.length)) {
            break;
         }
         if (e == b[i]) {
            copies++;
         }
         i++;
      }
      return b.length - copies;
   }
    
   /** Adds new element to an array.
    * @param arr array to add value.
    * @param val the value to add.
    * @return result the new array.
    */
   public static int[] addElement(int[] arr, int val) {
      int[] result = new int[arr.length + 1];
      int count = 0;
      
      for(int e : arr) {
         result[count] = e;
         count++;
      }
      result[count] = val;
      return result;
   }
    
   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    *
    * @param a array
    * @return min value in a
    * @throws IllegalArgumentException if a is invalid
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      if (a.length == 1) {
         return a[0];
      }
      
      int min = a[0];
      for (int e : a) {
         if (min > e) {
            min = e;
         }
      }
      
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    *
    * @param a array
    * @return max value in a
    * @throws IllegalArgumentException if a is invalid
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      if (a.length == 1) {
         return a[0];
      }
      
      int max = a[0];
      for (int e : a) {
         if (max < e) {
            max = e;
         }
      }
      
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    *
    * @param a array
    * @param k the min wanted
    * @return kmin value in a
    * @throws IllegalArgumentException if a is invalid
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length 
         || k > countCopies(a)) {
         throw new IllegalArgumentException();
      }
      
      if (a.length == 1 && k == 1) {
         return a[0];
      }
      if (a.length == 2 && k == 2 && a[0] != a[1]) {
         int[] temp = Arrays.copyOf(a, a.length);
         Arrays.sort(temp);
         return temp[1];
      }
      
      int[] temp = Arrays.copyOf(a, a.length);
      Arrays.sort(temp);
      return temp[k-1];
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    *
    * @param a array
    * @param k the max wanted
    * @return kmax value in a
    * @throws IllegalArgumentException if a is invalid
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int[] temp = Arrays.copyOf(a, a.length);
      int len = temp.length;
      int result = 0;
      Arrays.sort(temp);
      
      if (a.length == 1 && k ==1) {
         return a[0];
      }
      if (a.length == 2 && k ==2 && a[0] != a[1]) {
         return temp[1];
      }
      
      result = temp[len - k];
      return result;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    *
    * @param a array
    * @param low the low of the range
    * @param high the high of the range
    * @return range in a
    * @throws IllegalArgumentException if a is invalid
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      int[] result = new int[0];
      if (low <= high) {
         if (a.length == 1 && low >= a[0] && high <= a[0]) {
            return a;
         }
      
         for (int e : a) {
            if (e >= low && e <= high) {
               result = Selector.addElement(result, e);
            }
         }
      }
      if (result.length > 1) {
         Arrays.sort(result);
      }
      return result;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    *
    * @param a array
    * @param key 
    * @return next greater value in a
    * @throws IllegalArgumentException if a is invalid
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (a.length == 1 && a[0] >= key) {
         return a[0];
      }
      
      int[] temp = Arrays.copyOf(a, a.length);
      Arrays.sort(temp);
      
      for (int e : temp) {
         if (e >= key) {
            return e;
         }
      }
      throw new IllegalArgumentException();
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    *
    * @param a array
    * @param key
    * @return next lower value in a
    * @throws IllegalArgumentException if a is invalid
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (a.length == 1 && a[0] <= key) {
         return a[0];
      }
      
      int[] temp = Arrays.copyOf(a, a.length);
      Arrays.sort(temp);
      
      for (int e : temp) {
         if (e <= key) {
            return e;
         }
      }
      throw new IllegalArgumentException();
   }

}
