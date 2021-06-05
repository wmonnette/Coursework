import java.util.Scanner;

/** 
 * Display name, age, and gender.
 * Display age calculated in minutes and centuries
 * Display max heart rate based on age and gender
 *
 * @author Wesley Monnette
 * @version Sep 6 2017
 */
public class AgeStatistics {

   /** 
    * Allow for input of user name, age and gender.
    * @output age in minutes, centuries, and max HR
    * @param args not used
    */
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);
      String name = "";
      int ageYears = 0;
      int gender = 0;
      double maxHR = 0;
     
      // Get name from user
      System.out.println("Enter your name: ");
      name = userInput.nextLine();
     
      // Get age
      System.out.println("Enter your age in years: ");
      ageYears = userInput.nextInt();
     
      // Get gender
      System.out.println("Enter your gender (1 for female and 0 for male): ");
      gender = userInput.nextInt();
     
      // Convert age
      System.out.println("\tYour age in minutes is " + ageYears * 525600 
         + " minutes.");
      System.out.println("\tYour age in centuries is " 
         + (double) ageYears / 100 + " centuries.");
     
      // Display max HR
      System.out.print("Your max heart rate is ");
      if (gender == 1) {
    	   maxHR = 209 - (0.7 * (double) ageYears);
      } 
      else {
         maxHR = 214 - (0.8 * (double) ageYears);
      }
      System.out.println(maxHR + " beats per minute.");
     
   }
}