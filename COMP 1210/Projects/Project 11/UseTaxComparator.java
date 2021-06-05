import java.util.Comparator;
/**  
 * Project 11- UseTaxComparator.
 * @author: Wesley Monnette
 * @version: 11/29/2017 */
public class UseTaxComparator implements Comparator<Vehicle> {
 
 /** Sets compare method for vehicles based on use tax.
  * @param v1 for first vehicle
  * @param v2 for second vehicle
  * @return compare result value */
   public int compare(Vehicle v1, Vehicle v2) {
      if (v1.useTax() > v2.useTax()) {
         return -1;
      } 
      else if (v2.useTax() > v1.useTax()) {
         return 1;
      }
      return 0;
   }
}