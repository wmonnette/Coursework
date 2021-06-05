import java.util.Scanner;
   
/** Takes input and prints combination of bills to equal input.
 * @author Wesley Monnette
 * @version Sep 13 2017
 */
public class ATM {
   
   /** Prints to std output.
    * @param args not used
    */
   public static void main(String[] args) {
      
      // Variables
      Scanner in = new Scanner(System.in);
      int amountTemp;
      int withdrawal;
      int ones;
      int fives;
      int tens;
      int twenties;
      
      System.out.print("Enter the amount: ");
      withdrawal = in.nextInt();
      amountTemp = withdrawal;
      
      if (amountTemp > 500) { // Limit withdrawal amount
         System.out.println("Limit of $500 exceeded!");
      }
      else if (amountTemp < 0) { // Check if positive
         System.out.println("Amount must be positive!");
      }
      else { // Finds combination
         twenties = amountTemp / 20;
         amountTemp = amountTemp % 20;
         
         tens = amountTemp / 10;
         amountTemp = amountTemp % 10;
         
         fives = amountTemp / 5;
         amountTemp = amountTemp % 5;
         
         ones = amountTemp;
         
         // Output
         System.out.println("Bills by denomination:");
         System.out.println("\t$20: " + twenties);
         System.out.println("\t$10: " + tens);
         System.out.println("\t$5: " + fives);
         System.out.println("\t$1: " + ones);
         System.out.println("$" + withdrawal + " = (" + twenties 
            + " * $20) + (" + tens + " * $10) + (" + fives + " * $5) + (" 
            + ones + " * $1)");
      }
      
      
   }
}