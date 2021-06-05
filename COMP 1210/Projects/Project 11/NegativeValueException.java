/** Project 11- NegativeValueException
 * @author Wesley Monnette
 * @version Dec 8 2017 */
 public class NegativeValueException extends Exception {
   
   /** Catches negative values. */
   public NegativeValueException() {
      super("Numeric values must be nonnegative.");
   }
 }