import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
   
/** Get coded space ticket as input and decode for output.
 * @author Wesley Monnette
 * @version Sep 22 2017
 */
public class SpaceTicket {
   
   /** Constants  for discounts */
   static final double STUDENT = 0.25;
   static final double CHILD = 0.35;
      
   /** Prints to std output.
    * @param args not used
    */
   public static void main(String[] args) {
      
      // Variables
      String ticketCode, priceString, hour, minute, month, day, year, seat, 
         info;
      double price, cost;
      char category;
      int prizeNum;
      
      Scanner in = new Scanner(System.in);
      
      // Input
      System.out.print("Enter ticket code: ");
      ticketCode = in.nextLine();
      if (ticketCode.length() < 25) {
         System.out.println("\n*** Invalid ticket code ***" 
            + "\nTicket code must have at least 25 characters.");
         return;
      }
      
      // Calculation
      ticketCode = ticketCode.trim();
      
      priceString = ticketCode.substring(0,6).concat(".");
      priceString = priceString.concat(ticketCode.substring(6,8));
      price = Double.parseDouble(priceString);
      
      category = ticketCode.charAt(8);
      
      if (category == 's') {
         cost = price - (STUDENT * price);
      }
      else if (category == 'c') {
         cost = price - (CHILD * price);
      }
      else {
         cost = price;
      }
      
      hour = ticketCode.substring(9,11);
      minute = ticketCode.substring(11,13);
      month = ticketCode.substring(13,15);
      day = ticketCode.substring(15,17);
      year = ticketCode.substring(17,21);
      seat = ticketCode.substring(21,24);
      info = ticketCode.substring(24);
      
      Random rand = new Random();
      prizeNum = rand.nextInt(999999) + 1;
      
      
      // Output
      DecimalFormat costFormat = new DecimalFormat("$#00,000.00");
      DecimalFormat prizeFormat = new DecimalFormat("000000");
      
      System.out.println("\nSpace Ticket: " + info);
      System.out.println("Date: " + month + "/" + day + "/" + year 
         + "   Time: " + hour + ":" + minute + "   Seat: " + seat);
      System.out.println("Price: " + costFormat.format(price) + "   Category: " 
         + category + "   Cost: " + costFormat.format(cost));
      System.out.print("Prize Number: " + prizeFormat.format(prizeNum));
   }
}