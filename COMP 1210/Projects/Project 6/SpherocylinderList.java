import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
/** Finds list name, creates array, and total and average SA and volume. 
 * Project 6- SpherocylinderList
 * @author: Wesley Monnette
 * @version: 10/18/2017
 */

public class SpherocylinderList {
/** Creates list of spherocylinders. */
   
   // Fields
   private String listName;
   private ArrayList<Spherocylinder> scList;
   
   // Constructor
   /** @param nameIn for name
    * @param listIn for list */
   public SpherocylinderList(String nameIn, ArrayList<Spherocylinder> listIn) {
      listName = nameIn;
      scList = listIn;
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
      return scList.size();
   }
   
   /** Finds total surface area.
    * @return totalSurfaceArea */
   public double totalSurfaceArea() {
      double totalSurfaceArea = 0;
      int index = 0;
      while (index < scList.size()) {
         totalSurfaceArea += scList.get(index).surfaceArea();
         index++;
      }
      return totalSurfaceArea;
   }
   
   /** Finds total volume.
    * @return totalVolume */
   public double totalVolume() {
      double totalVolume = 0;
      int index = 0;
      while (index < scList.size()) {
         totalVolume += scList.get(index).volume();
         index++;
      }
      return totalVolume;
   }
   
   /** Finds average surface area.
    * @return averageSurfaceArea */
   public double averageSurfaceArea() {
      double averageSurfaceArea = 0;
      if (scList.size() == 0) {
         return averageSurfaceArea;
      } else {
         averageSurfaceArea = totalSurfaceArea() / scList.size();
         return averageSurfaceArea;
      }
   }
   
   /** Finds average volume.
    * @return averageVolume */
   public double averageVolume() {
      double averageVolume = 0;
      if (scList.size() == 0) {
         return averageVolume;
      } else {
         averageVolume = totalVolume() / scList.size();
         return averageVolume;
      }
   }
   
   /** Creates output.
    * @return result */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < scList.size()) {
         result += "\n" + scList.get(index) + "\n";
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
   
   /** @return myList of spherocylinder objects. */
   public ArrayList<Spherocylinder> getList() {
      SpherocylinderList myList = new ArrayList<Spherocylinder> ();
      return myList;
   }
   
   /** Reads data from file and creates object.
    * @param fileNameIn for fileName
    * @return scObjList 
    * @throws FileNotFoundException if file cannot be opened */
   public SpherocylinderList readFile(String fileNameIn)
                                       throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<Spherocylinder> myList = new ArrayList<Spherocylinder>();
      String myListName = "";
      String label = "";
      double radius = 0, cylH = 0;
      
      myListName = scanFile.nextLine();
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         radius = Double.parseDouble(scanFile.nextLine());
         cylH = Double.parseDouble(scanFile.nextLine());
         Spherocylinder sc = new Spherocylinder(label, radius, cylH);
         myList.add(sc);
      }
      SpherocylinderList scObjList = new SpherocylinderList(listName, myList);
      return scObjList;
   }
   
   /** Adds spherocylinder to list.
    * @param label for lablIn
    * @param radius for radiusIn
    * @param cylH for cylHIn */
   public void addSpherocylinder(String label, double radius, double cylH) {
      Spherocylinder sc = new Spherocylinder(label, radius, cylH);
      myList.add(sc);
   }
   
   /**
    * @param label for label of spherocylinder to find 
    * @return scArray of corresponding spherocylinder */
   public boolean findSpherocylinder(String label) {
      return result;
   }
   
   /** 
    * @param label for label of spherocylinder to delete 
    * @return result of deleted spherocylinder */
   public boolean deleteSpherocylinder(String label) {
      return result;
   }
   
   /**
    * @param label for label of spherocylinder to edit
    * @param radius for radius of spherocylinder to edit
    * @param cylH for cylinder height of spherocylinder to edit 
    * @return result of edited spherocylinder */
   public boolean editSpherocylinder(String label, double radius, double cylH)
   {
      return result;
   }
}