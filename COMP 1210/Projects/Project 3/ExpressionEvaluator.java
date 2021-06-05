import java.util.Scanner;
import java.text.DecimalFormat;
   
/** Calculates expression.
 * @author Wesley Monnette
 * @version Sep 22 2017
 */
public class ExpressionEvaluator {
   
   /** Prints to std output.
    * @param args not used
    */
   public static void main(String[] args) {
      
      // Variables
      double x;
      double rTop, rBottom, result;
      String resultStr, numbersL, numbersR;
      int decimalI, countL, countR;
      Scanner in = new Scanner(System.in);
   
      // Input
      System.out.print("Enter a value for x: ");
      x = in.nextDouble();
      
      // Calculations
      rTop = Math.pow((3 * Math.pow(x, 5) - 2 * Math.pow(x, 3)), 2);
      rBottom = Math.sqrt(Math.abs(16 * Math.pow(x, 7))) + 1;
      result = rTop / rBottom;
      
      resultStr = Double.toString(result);
      decimalI = resultStr.indexOf('.');
      numbersL = resultStr.substring(0, decimalI);
      numbersR = resultStr.substring(decimalI + 1, resultStr.length());
      countL = numbersL.length();
      countR = numbersR.length();   
      
      // Output
      DecimalFormat df = new DecimalFormat("#,##0.0####");
      System.out.println("Result: " + result);
      System.out.println("# digits to left of decimal point: " + countL);
      System.out.println("# digits to right of decimal point: " + countR);
      System.out.println("Formatted Result: " + df.format(result));
   }
}