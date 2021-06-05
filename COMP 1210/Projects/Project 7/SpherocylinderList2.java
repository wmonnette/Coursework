import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
/** Finds list name, creates array, and total and average SA and volume. 
 * Project 7- SpherocylinderList2
 * @author: Wesley Monnette
 * @version: 10/26/2017
 */
 
public class SpherocylinderList2 {

// Instance variables
   private String listName;
   private Spherocylinder[] scList;
   private int numSC;

// Constructor
/** Creates list.
 * @param listNameIn for listName
 * @param scListIn for scList
 * @param numSCIn for numSC */
   public SpherocylinderList2(String listNameIn, Spherocylinder[] scListIn,
                            int numSCIn) {
      listName = listNameIn;
      scList = scListIn;
      numSC = numSCIn;
   }

// Methods
/** Get listName.
 * @return listName */
   public String getName() {
      return listName;
   }

/** Gets number of spherocylinders.
 * @return numSC */
   public int numberOfSpherocylinders() {
      return numSC;
   }
   
/** Finds total surface area.
 * @return tSA */
   public double totalSurfaceArea() {
      double tSA = 0;
      int index = 0;
      while (index < numSC) {
         tSA += scList[index].surfaceArea();
         index++;
      }
      return tSA;
   }
   
/** Finds total volume.
 * @return tVol */
   public double totalVolume() {
      double tVol = 0;
      int index = 0;
      while (index < numSC) {
         tVol += scList[index].volume();
         index++;
      }
      return tVol;
   }

/** Finds average surface area.
 * @return avgSA */
   public double averageSurfaceArea() {
      double avgSA = 0;
      if (numSC == 0) {
         return avgSA;
      } else {
         avgSA = totalSurfaceArea() / (double) numSC;
         return avgSA;
      }
   }
   
/** Finds average volume.
 * @return avgVol */
   public double averageVolume() {
      double avgVol = 0;
      if (numSC == 0) {
         return avgVol;
      } else {
         avgVol = totalVolume() / (double) numSC;
         return avgVol;
      }
   }
   
/** Creates output.
 * @return result */
   public String toString() {
      String result = listName + "\n";
      int index = 0;
      while (index < numSC) {
         result += "\n" + scList[index] + "\n";
         index++;
      }
      return result;
   }
   
/** Creates summary info.
 * @return output */
   public String summaryInfo() {
      DecimalFormat df1 = new DecimalFormat("#,##0.0##");
      String output = "";
      output += "----- Summary for " + getName() + " -----";
      output += "\nNumber of Spherocylinders: " + numberOfSpherocylinders();
      output += "\nTotal Surface Area: " + df1.format(totalSurfaceArea());
      output += "\nTotal Volume: " + df1.format(totalVolume());
      output += "\nAverage Surface Area: " + df1.format(averageSurfaceArea());
      output += "\nAverage Volume: " + df1.format(averageVolume());
      return output;
   }
   
/** Gets array of spherocylinder objects. 
 * @return scObjList */
   public Spherocylinder[] getList() {
      return scList;
   }
   
/** Reads data from file and creates object.
    * @param fileNameIn for fileName
    * @return scObjList 
    * @throws FileNotFoundException if file cannot be opened */
   public SpherocylinderList2 readFile(String fileNameIn)
                                       throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      Spherocylinder[] scObjList = new Spherocylinder[numSC];
      listName = scanFile.nextLine();
      String labelIn = "";
      double radiusIn = 0, cylHIn = 0;
      
      while (scanFile.hasNext()) {
         labelIn = scanFile.nextLine();
         radiusIn = Double.parseDouble(scanFile.nextLine());
         cylHIn = Double.parseDouble(scanFile.nextLine());
         Spherocylinder newSC = new Spherocylinder(labelIn, radiusIn, cylHIn);
         scList[numSC] = newSC;
         numSC++;
      }
      SpherocylinderList2 newSCList = new SpherocylinderList2(listName, scList,
            numSC);
      return newSCList;
   }
   
   /** Adds a spherocylinder to array list.
    * @param labelIn for label
    * @param radiusIn for radius
    * @param cylHIn for cylinder height */
   public void addSpherocylinder(String labelIn, double radiusIn, 
      double cylHIn) {
      Scanner scan = new Scanner(System.in);
      Spherocylinder scAdd = new Spherocylinder(labelIn, radiusIn, cylHIn);
      scList[numSC] = scAdd;
      numSC++;
   } 
   
   /** Finds a spherocylinder in array list.
    * @param labelIn for label of spherocylinder
    * @return spherocylinder found in list */
   public Spherocylinder findSpherocylinder(String labelIn) {
      Spherocylinder result = null;
      for (int i = 0; i < numSC; i++) {
         if (scList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = scList[i];
            break;
         }
      }
      return result;
   }
   
   /** Deletes spherocylinder in the list.
    * @param labelIn for label of spherocylinder
    * @return spherocylinder found in list */
   public Spherocylinder deleteSpherocylinder(String labelIn) {
      Spherocylinder result = null;
      for (int i = 0; i < numSC; i++) {
         if (scList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = scList[i];
            for (int j = i; j <= numSC - 1; j++) {   
               scList[j] = scList[j + 1];
            }
            scList[numSC - 1] = null;
            numSC--;
            break;
         }
      }
      return result;
   }
 
 /** Edits a spherocylinder in array list.
  * @param labelIn for label
  * @param radiusIn for radius
  * @param cylHIn for cylH
  * @return the spherocylinder from the list */
   public boolean editSpherocylinder(String labelIn, double radiusIn,
      double cylHIn) {
      Spherocylinder result = null;
      boolean bobs = false;
      for (int i = 0; i < numSC; i++) {
         if (scList[i].getLabel().equalsIgnoreCase(labelIn)) {
            scList[i].setRadius(radiusIn);
            scList[i].setCylinderHeight(cylHIn);
            result = scList[i];
            bobs = true;
         }
      }
      return bobs;
   }
   
   /** Find spherocylinder with smallest radius.
    * @return result of smallest radius spherocylinder */
   public Spherocylinder findSpherocylinderWithShortestRadius() {
      Spherocylinder result;
      if (numSC <= 0) {
         return null;
      } else {
         double min = scList[0].getRadius();
         result = scList[0];
         for (int i = 1; i < numSC; i++) {
            if (scList[i].getRadius() < min) {
               min = scList[i].getRadius();
               result = scList[i];
            }
         }
      }
      return result;
   }
   
   /** Finds spherocylinder with largest radius.
    * @return result of largest radius spherocylinder */
   public Spherocylinder findSpherocylinderWithLongestRadius() {
      Spherocylinder result;
      if (numSC <= 0) {
         return null;
      } else {
         double max = scList[0].getRadius();
         result = scList[0];
         for (int i = 1; i < numSC; i++) {
            if (scList[i].getRadius() > max) {
               max = scList[i].getRadius();
               result = scList[i];
            }
         }
      }
      return result;
   }
   
   /** Finds spherocylinder with smallest volume.
    * @return result of smallest volume spherocylinder */
   public Spherocylinder findSpherocylinderWithSmallestVolume() {
      Spherocylinder result;
      if (numSC <= 0) {
         return null;
      } else {
         double min = scList[0].getVolume();
         result = scList[0];
         for (int i = 1; i < numSC; i++) {
            if (scList[i].getVolume() < min) {
               min = scList[i].getVolume();
               result = scList[i];
            }
         }
      }
      return result;
   }
   
   /** Finds spherocylinder with largest volume.
    * @return result of largest volume spherocylinder */
   public Spherocylinder findSpherocylinderWithLargestVolume() {
      Spherocylinder result;
      if (numSC <= 0) {
         return null;
      } else {
         double max = scList[0].getVolume();
         result = scList[0];
         for (int i = 1; i < numSC; i++) {
            if (scList[i].getVolume() > max) {
               max = scList[i].getVolume();
               result = scList[i];
            }
         }
      }
      return result;
   }
}