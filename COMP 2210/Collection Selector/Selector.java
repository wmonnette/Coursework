import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Wesley Monnette (wjm0017@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2/5/2019
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


   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      // Checks if coll or comp are null or empty
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("must be an array of at least "
                 + "one integer");
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a collection that is "
                 + "not empty");
      }
      
      Iterator<T> ite = coll.iterator();
      T min;
      min = ite.next();
   
      if (ite.hasNext()) {
         for (T element: coll) {
            if (comp.compare(element, min) < 0) {
               min = element;
            }
         }
      }
      return min;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      // Checks if coll or comp are null or empty
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("must be an array of at least "
                 + "one integer");
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a collection that is "
                 + "not empty");
      }
   
      Iterator<T> ite = coll.iterator();
      T max;
      max = ite.next();
   
      if (ite.hasNext()) {
         for (T element : coll) {
            if (comp.compare(element, max) > 0) {
               max = element;
            }
         }
      }
      return max;
   }      }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      // Checks if coll or comp are null or empty
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("must be an array of at least "
                 + "one integer");
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a collection that is "
                 + "not empty");
      }
   
      // Creates an arraylist of coll and sorts it
      List<T> list = new ArrayList(coll);
      java.util.Collections.sort(list, comp);
   
      // Checks k
      if (k > list.size() || k <= 0) {
         throw new NoSuchElementException("k-1 must be within array");
      }
   
      // Counts unique and duplicate numbers, deletes duplicates
      int duplicateCount = 0;
      int uniqueCount = 0;
      int originalCount = list.size();
      for (int i = 0; i < list.size() - 1; i++) {
         while (list.size() > 1 && i < list.size() - 1
                 && list.get(i) == list.get(i + 1)) {
            list.remove(i);
            duplicateCount++;
         }
      }
   
      uniqueCount = originalCount - duplicateCount;
   
      // Checks if k > unique count
      if (k > uniqueCount) {
         throw new NoSuchElementException("k must be less than the number" 
                + "of unique numbers");
      }
      return list.get(k - 1);
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      // Checks if coll or comp are null or empty
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("must be an array of at least "
                 + "one integer");
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a collection that is "
                 + "not empty");
      }
   
      // Creates an arraylist of coll and sorts it
      List<T> list = new ArrayList(coll);
      java.util.Collections.sort(list, comp);
   
      // Checks k
      if (k > list.size() || k <= 0) {
         throw new NoSuchElementException("k-1 must be within array");
      }
   
      // Counts unique and duplicate numbers, deletes duplicates
      int duplicateCount = 0;
      int uniqueCount = 0;
      int originalCount = list.size();
      for (int i = 0; i < list.size() - 1; i++) {
         while (list.size() > 1 && i < list.size() - 1
                 && list.get(i) == list.get(i + 1)) {
            list.remove(i);
            duplicateCount++;
         }
      }
   
      uniqueCount = originalCount - duplicateCount;
   
      // Checks if k > unique count
      if (k > uniqueCount) {
         throw new NoSuchElementException("k must be less than the number" 
                + "of unique numbers");
      }
      return list.get(uniqueCount - k);
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
     // Checks if coll or comp are null or empty
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("must be an array of at least "
                 + "one integer");
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a collection that is "
                 + "not empty");
      }
   
      /* Creates arraylist of original and range
       * Sets j for number of qualified values */
      List<T> list = new ArrayList(coll);
      List<T> range = new ArrayList(coll);
      int j = 0;
   
      // Rewrites copy so values in range are first in the array
      for (int i = 0; i < list.size(); i++) {
         if ((comp.compare(list(i), low) >= 0)
            && (comp.compare(list(i), high) <= 0)) {
            range.set(j, list.get(i));
            j++;
         }
      }
   
      // Catches if no values from list in range
      if (j == 0) {
         throw new NoSuchElementException("Collection must contain values " 
                  + "within the range");
      }
   
      // Deletes extra values from range
      for (int i = range.size() - 1; i > j - 1; i--) {
         range.remove(i);
      }
   
      return range;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      // Checks if coll or comp are null or empty
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("must be an array of at least "
                 + "one integer");
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a collection that is "
                 + "not empty");
      }
      
      // Finds the max value in the collection
      Iterator<T> ite = coll.interator();
      T ceiling;
      ceiling = ite.next();
      if (ite.hasNext()) {
         for (T element: coll) {
            if (comp.compare(element, ceiling) > 0) {
               ceiling = element;
            }
         }
      }
      
      int change = 0;
      
      // Finds lowest value >= key
      for (T element: coll) {
         if ((comp.compare(element, key) >= 0) 
               && comp.compare((element, ceiling) <= 0)) {
            ceiling = element;
            change++;         
         }
      }
      
      // If no valid element
      if (change == 0)  {
         throw new NoSuchElementException("No valid value in coll");
      }
      
      return ceiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      // Checks if coll or comp are null or empty
      if (coll == null || comp == null) {
         throw new IllegalArgumentException("must be an array of at least "
                 + "one integer");
      }
   
      if (coll.isEmpty()) {
         throw new NoSuchElementException("must be a collection that is "
                 + "not empty");
      }
      
      // Finds min
      Iterator<T> ite = coll.iterator();
      T floor;
      floor = ite.next();
      if (ite.hasNext))) {
         for (T element: coll) {
            if (comp.compare(element, coll) < 0) {
               floor = element;
            }
         }
      }
      
      int change = 0;
      
      // Finds the lowest value >= key
      for (T element: coll) {
         if ((comp.compare(element, key) <= 0) 
               && comp.compare((element, ceiling) >= 0)) {
            floor = element;
            change++;         
         }
      }
      
      // If no valid element
      if (change == 0)  {
         throw new NoSuchElementException("No valid value in coll");
      
      return floor;
   }
}