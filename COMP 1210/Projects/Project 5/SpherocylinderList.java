import java.util.ArrayList;
import java.text.DecimalFormat;
/** Finds list name, creates array, and total and average SA and volume. 
 * Project 5- SpherocylinderList
 * @author: Wesley Monnette
 * @version: 10/9/2017
 */

public class SpherocylinderList {
/** Creates list of spherocylinders. */
   
   // Fields
   private String listName;
   private ArrayList<Spherocylinder> myList;
   
   // Constructor
   /** @param nameIn for name
    * @param listIn for list */
   public SpherocylinderList(String nameIn, ArrayList<Spherocylinder> listIn) {
      listName = nameIn;
      myList = listIn;
   }
   
   // Methods
   /** Get list name.
    * @return listName */
   public String getName() {
      return listName;
   }
   
   /** Returns number of spherocylinders.
    * @return numCyl */
   public int numberOfSpherocylinders() {
      return myList.size();
   }
   
   /** Finds total surface area.
    * @return totalSurfaceArea */
   public double totalSurfaceArea() {
      double totalSurfaceArea = 0;
      int index = 0;
      while (index < myList.size()) {
         totalSurfaceArea += myList.get(index).surfaceArea();
         index++;
      }
      return totalSurfaceArea;
   }
   
   /** Finds total volume.
    * @return totalVolume */
   public double totalVolume() {
      double totalVolume = 0;
      int index = 0;
      while (index < myList.size()) {
         totalVolume += myList.get(index).volume();
         index++;
      }
      return totalVolume;
   }
   
   /** Finds average surface area.
    * @return averageSurfaceArea */
   public double averageSurfaceArea() {
      double averageSurfaceArea = 0;
      if (myList.size() == 0) {
         return averageSurfaceArea;
      } else {
         averageSurfaceArea = totalSurfaceArea() / myList.size();
         return averageSurfaceArea;
      }
   }
   
   /** Finds average volume.
    * @return averageVolume */
   public double averageVolume() {
      double averageVolume = 0;
      if (myList.size() == 0) {
         return averageVolume;
      } else {
         averageVolume = totalVolume() / myList.size();
         return averageVolume;
      }
   }
   
   /** Creates output.
    * @return result */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < myList.size()) {
         result += "\n" + myList.get(index) + "\n";
         index++;
      }
      return result;
   }
   
   /** Creates summary.
    * @return sumInfo */
   public String summaryInfo() {
      DecimalFormat df1 = new DecimalFormat("#,##0.0##");
      String sumInfo = "";
      sumInfo += "\n----- Summary for " + getName() + " -----";
      sumInfo += "\nNumber of Spherocylinders: " + numberOfSpherocylinders();
      sumInfo += "\nTotal Surface Area: " + df1.format(totalSurfaceArea());
      sumInfo += "\nTotal Volume: " + df1.format(totalVolume());
      sumInfo += "\nAverage Surface Area: " + df1.format(averageSurfaceArea());
      sumInfo += "\nAverage Volume: " + df1.format(averageVolume());
      return sumInfo;
   }
}