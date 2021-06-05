/** Evaluates arrays of numbers.
 * Activity 7
 * @author: Wesley Monnette
 * @version: 10/23/2017 */

public class Scores {

// instance variables
   private int[] numbers;

// constructor
/** Sets input to be used in array.
 * @param numbersIn for numbers */
   public Scores(int[] numbersIn) {
      numbers = numbersIn;
   }

// methods
/** Finds evens in array of scores.
 * @return evens */
   public int[] findEvens() {
      int numberEvens = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            numberEvens++;
         }
      }
      int[] evens = new int[numberEvens];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 0) {
            evens[count] = numbers[i];
            count++;
         }
      }
      return evens;
   }
   
/** Finds odds in array of scores. 
 * @return odds */
   public int[] findOdds() {
      int numberOdds = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            numberOdds++;
         }
      }
      int[] odds = new int[numberOdds];
      int count = 0;
      for (int i = 0; i < numbers.length; i++) {
         if (numbers[i] % 2 == 1) {
            odds[count] = numbers[i];
            count++;
         }
      }
      return odds;
   }
   
/** Finds average of array of scores. 
 * @return avg */
   public double calculateAverage() {
      int sum = 0;
      for (int i = 0; i < numbers.length; i++) {
         sum += numbers[i];
      }
      return sum / (double) numbers.length;
   }

/** Outputs all scores. 
 * @return result */
   public String toString() {
      String result = "";
      for (int i = 0; i < numbers.length; i++) {
         result += numbers[i] + "\t";
      }
      return result;
   }

/** Outputs all scores in reverse.
 * @return result */
   public String toStringInReverse() {
      String result = "";
      for (int i = numbers.length - 1; i >= 0; i--) {
         result += numbers[i] + "\t";
      }
      return result;
   } 
}