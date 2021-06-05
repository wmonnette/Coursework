/**
 * Holds an integer and has methods to modify that number.
 * @author Wesley Monnette
 * @version Oct 4 2017 
 */
public class NumberOperations {
   
  // Variables
   private int number;
   
   /**
    * Constructor.
    * @param numberIn number in
    */
   public NumberOperations(int numberIn) {
      number = numberIn;
   }
   
  // Methods
  /**
   * Returns value.
   * @return integer
   */
   public int getValue() {
      return number;
   }
   
   /**
    * Finds odd numbers less than number.
    * @return output a string of those numbers
    */
   public String oddsUnder() {
      String output = "";
      
      int i = 0;
      while (i < number) {
         if (i % 2 != 0) {
            output += i + "\t";
         }
         i++;
      }
      
      return output;
   }
   
   /**
    * Finds numbers of the power 2 less than number.
    * @return output a string of those numbers
    */
   public String powersTwoUnder() {
      String output = "";
      
      int powers = 1;
      while (powers < number) {
         output += powers + "\t";
         powers = powers * 2;
      }
      return output;
   }
   
   /**
    * .
    * @param compareNum number to compare
    * @return integer
    */
   public int isGreater(int compareNum) {
      if (number > compareNum) {
         return 1;
      }
      if (number < compareNum) {
         return -1;
      }
      else {
         return 0;
      }
   }
   
   /**
    * Outputs to string.
    * @return string
    */
   public String toString() {
      return number + "";
   }
}