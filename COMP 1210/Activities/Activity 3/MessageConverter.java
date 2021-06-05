import java.util.Scanner;

/**
 * Exchange letters in a String to encode a message.
 * @author Wesley Monnette
 * @version Sep 18 2017
 */
public class MessageConverter {
   
   /**
    * @func Encodes a string.
    * @output Encoded String.
    * @param args not used
    */
   public static void main(String[] args) {
      String message = "";
      String result = "";
      int outType = 0;
      Scanner userIn = new Scanner(System.in);
      
      System.out.print("Type in a message and press enter: \n\t> ");
      message = userIn.nextLine();
      
      System.out.print("\nOutput types:"
         + "\n\t0: As is"
         + "\n\t1: Trimmed"
         + "\n\t2: lower case"
         + "\n\t3: UPPER CASE"
         + "\n\t4: v_w_ls r_pl_c_d"
         + "\n\t5: Without first and last character"
         + "\nEnter your choice: ");
      outType = Integer.parseInt(userIn.nextLine());
      
      if (outType == 0) { // as is
         result = message;
      }
      else if (outType == 1) { // trimmed
         result = message.trim();
      }
      else if (outType == 2) { // lower case
         result = message.toLowerCase();
      }
      else if (outType == 3) { // upper case
         result = message.toUpperCase();
      }
      else if (outType == 4) { // delete vowels
         result = message.replace('a', '_');
         result = result.replace('e', '_');
         result = result.replace('i', '_');
         result = result.replace('o', '_');
         result = result.replace('u', '_');
      }
      else if (outType == 5) { // without first and last
         result = message.substring(1, message.length() - 1);
      }
      else { // invalid input
         result = "Error: Invalid choice input.";
      }
      
      System.out.println("\n" + result);   
   }
}