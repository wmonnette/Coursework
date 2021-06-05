import java.util.Scanner;
   
/** Calculates result given values for x, y, and z.
 * @author Wesley Monnette
 * @version Sep 13 2017
 */
public class FormulaCalculator {
   
   /** Prints to std output.
    * @param args not used
    */
   public static void main(String[] args) {
      // Variables
      double x, y, z, result;
      Scanner in = new Scanner(System.in);
      
      // Input stuff
      System.out.println("result = (2x - 7.4) (4y + 9.3) (6z - 11.2) / xyz");
      System.out.print("\tEnter x: ");
      x = in.nextDouble();
      System.out.print("\tEnter y: ");
      y = in.nextDouble();
      System.out.print("\tEnter z: ");
      z = in.nextDouble();
      
      // Calculate result
      if ( x == 0 || y == 0 || z == 0) {
         result = 0.0;
      }
      else {
         result = (((2 * x - 7.4) * (4 * y + 9.3) * (6 * z - 11.2)) 
            / (x * y * z));
      }
      
      // Output
      System.out.println("result = " + result);
   }
}