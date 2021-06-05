/** 
 * Activity 11- Division.
 * @author: Wesley Monnette
 * @version: 12/4/2017 */
 
public class Division {
  
  // Methods
  /** Divides two integers.
   * @param num for numerator
   * @param denom for denominator
   * @return result */
   public static int intDivide(int num, int denom) {
      try {
         return num / denom;
      }
      catch (ArithmeticException e) {
         return 0;
      }
   }
  
  /** Divides two integers in floating point.
   * @param num for numerator
   * @param denom for denominator
   * @return result */
   public static double decimalDivide(int num, int denom) {
      if (denom == 0) {
         throw new IllegalArgumentException("The denominator cannot be zero");
      }
      return ((double) num / denom);
   }
}