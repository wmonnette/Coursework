import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/** Uses SpherocylinderList and Spherocylinder classes.
 * Project 5- SpherocylinderListApp
 * @author: Wesley Monnette
 * @version: 10/9/2017
 */
 
public class SpherocylinderListApp {
/** Reads file with data, creates and prints SpherocylinderList and it's
 * summary.
 * @param args not used
 * @throws FileNotFoundException required by Scanner for file */
 
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<Spherocylinder> myList = new ArrayList<Spherocylinder>();
      String label;
      double radius;
      double cylH;
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      Scanner scanFile = new Scanner(new File(fileName));
      String listName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         radius = Double.parseDouble(scanFile.nextLine());
         cylH = Double.parseDouble(scanFile.nextLine());
         Spherocylinder sc = new Spherocylinder(label, radius, cylH);
         myList.add(sc);
      }
      scanFile.close();
      SpherocylinderList mySCList = new SpherocylinderList(listName, myList);
      System.out.println("\n" + mySCList.toString());
      System.out.println(mySCList.summaryInfo());
   }
}