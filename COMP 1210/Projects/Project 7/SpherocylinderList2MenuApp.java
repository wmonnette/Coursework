import java.util.Scanner;
import java.io.FileNotFoundException;
/** Finds list name, creates array, and total and average SA and volume. 
 * Project 7- SpherocylinderList2MenuApp
 * @author: Wesley Monnette
 * @version: 10/26/2017
 */
public class SpherocylinderList2MenuApp {

/** Creates menu for user.
 * @param args are used
 * @throws FileNotFoundException required by Scanner for file */
   public static void main(String[] args) throws FileNotFoundException {
      String scListName = "*** no list name assigned ***";
      Spherocylinder[] myList = new Spherocylinder[100];
      SpherocylinderList2 mySCList = new 
         SpherocylinderList2(scListName, myList, 0);
      String fileName = "no file name";
      String label = "";                              
      double radius = 0, cylH = 0;
      String code = "";
      Scanner scan = new Scanner(System.in);
      System.out.println("Spherocylinder List System Menu\n"
                        + "R - Read File and Create Spherocylinder List\n"
                        + "P - Print Spherocylinder List\n"
                        + "S - Print Summary\n"
                        + "A - Add Spherocylinder\n"
                        + "D - Delete Spherocylinder\n"
                        + "F - Find Spherocylinder\n"
                        + "E - Edit Spherocylinder\n"
                        + "Q - Quit");
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         code = scan.nextLine();
         if (code.length() == 0) {
            continue;
         }
         code = code.toUpperCase();
         char codeChar = code.charAt(0);
         switch(codeChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
               mySCList = mySCList.readFile(fileName);
               System.out.println("\tFile read in and Spherocylinder List"
                                 + " created\n");
               break;
            
            case 'P':
               System.out.println("\n" + mySCList);
               break;
            
            case 'S':
               System.out.println("\n" + mySCList.summaryInfo() + "\n");
               break;
            
            case 'A':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scan.nextLine());
               System.out.print("\tCylinder Height: ");
               cylH = Double.parseDouble(scan.nextLine());
               mySCList.addSpherocylinder(label, radius, cylH);
               System.out.println("\t*** Spherocylinder added ****\n");
               break;
            
            case 'D':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               if (mySCList.deleteSpherocylinder(label) != null) {
                  System.out.println("\t\"" + label + "\" deleted\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            
            case 'F':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               if (mySCList.findSpherocylinder(label) != null) {
                  System.out.println("\t" + mySCList.findSpherocylinder(label)
                        + "\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            
            case 'E':
               System.out.print("\tLabel: ");
               label = scan.nextLine();
               System.out.print("\tRadius: ");
               radius = Double.parseDouble(scan.nextLine());
               System.out.print("\tCylinder Height: ");
               cylH = Double.parseDouble(scan.nextLine());
               if (mySCList.editSpherocylinder(label, radius, cylH)) {
                  System.out.println("\t\"" + label 
                     + "\" successfully edited\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
                  break;
               }
            
            case 'Q':
               break;
            
            default:
               System.out.println("\t*** invalid code ***\n");
               break;
         }  
      } while (!code.equalsIgnoreCase("Q"));
   }
}