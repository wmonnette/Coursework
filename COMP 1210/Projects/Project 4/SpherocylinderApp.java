import java.util.Scanner;

/**
 * Access methods and prints messages.
 * Project 4- SpherocylinderApp
 * @author: Wesley Monnette
 * @version: 9/27/2017
 */
public class SpherocylinderApp {
  
  /** Driver.
   * @param args not used
   */
   public static void main(String[] args) {
      String name;
      double radius = 0.0;
      double cylH = 0.0;
      double temp = 0.0;
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter label, radius, and cylinder height for a " 
         + "spherocylinder.");
      System.out.print("\tlabel: ");
      name = in.nextLine();
      
      System.out.print("\tradius: ");
      temp = Double.parseDouble(in.nextLine());
      if (temp > 0) {
         radius = temp;
      }
      else {
         System.out.println("Error: radius must be non-negative.");
         return;
      }
      
      System.out.print("\tcylinder height: ");
      temp = Double.parseDouble(in.nextLine());
      if (temp > 0) {
         cylH = temp;
      }
      else {
         System.out.println("Error: cylinder height must be non-negative.");
         return;
      }
      
      Spherocylinder sC = new Spherocylinder(name, radius, cylH);
      System.out.println("\n" + sC);
   }
}