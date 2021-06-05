import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
/** 
 * Project 10- UseTaxList.
 * @author: Wesley Monnette
 * @version: 12/9/2017 */
public class UseTaxList {
   
   // Fields
   private String taxDistrict;
   private Vehicle[] vehicleList;
   private int vehicleCount;
   private String[] excludedRecords;
   private int excludedCount;
   
   // Constructor
   /** Constructs. */
   public UseTaxList() {
      taxDistrict = "not yet assigned";
      vehicleList = new Vehicle[0];
      excludedRecords = new String[0];
   }
    
   // Methods
   /** Reads in new vehicle file.
    * @param fileNameIn for fileName
    * @throws FileNotFoundException if no file found */
   public void readVehicleFile(String fileIn) throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileIn));
      taxDistrict = scanFile.nextLine();
      while (scanFile.hasNext()) {
      
         //try {
         String line = scanFile.nextLine();
         Scanner scanVehicle = new Scanner(line);
         scanVehicle.useDelimiter(";");
         
         char vehicleType = scanVehicle.next().charAt(0);
         String ownerIn = scanVehicle.next();
         String yearMakeModelIn = scanVehicle.next();
         double valueIn = Double.parseDouble(scanVehicle.next());
         boolean altFuelIn = Boolean.parseBoolean(scanVehicle.next());
         Vehicle v;
         
         switch (vehicleType) {
            case 'C':
               v = new Car(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
                  //vehicleList.addVehicle(v);
               break;
            
            case 'T':
               double tonsIn = Double.parseDouble(scanVehicle.next());
               v = new Truck(ownerIn, yearMakeModelIn, valueIn, altFuelIn,
                     tonsIn);
                  //vehicleList.addVehicle(v);
               break;
            
            case 'S':
               double tonIn = Double.parseDouble(scanVehicle.next());
               int axlesIn = Integer.parseInt(scanVehicle.next());
               v = new SemiTractorTrailer(ownerIn, yearMakeModelIn, valueIn, 
                     altFuelIn, tonIn, axlesIn);
                  //vehicleList.addVehicle(v);
               break;
               
            case 'M':
               double engSizeIn = Double.parseDouble(scanVehicle.next());
               v = new Motorcycle(ownerIn, yearMakeModelIn, valueIn, altFuelIn,
                     engSizeIn);
                  //vehicleList.addVehicle(v);   
               break;
               
            default:
                  //throw new InvalidCatagoryException(line);
               break;
         }
      }
         //catch (NumberFormatException e) {
            //String output = e + " in: " + line;
            //excludedRecords.addExcludedRecord(output);
         //}
         //catch (InvalidCatagoryException e) {
            //String output = e + " in: " + line;
            //excludedRecords.addExcludedRecord(output);
         //}
         //catch (NoSuchElementException e) {
            //String output = e + " in: " + line;
            //excludedRecords.addExcludedRecord(output);  
         //}
      //}
      scanFile.close();
      
   }
   
   /** Returns tax district.
    * @return taxDistrict */
   public String getTaxDistrict() {
      return taxDistrict;
   }
    
   /** Sets tax district.
    * @param taxDistrictIn for taxDistrict */
   public void setTaxDistrict(String taxDistrictIn) {
      taxDistrict = taxDistrictIn;
   }
     
   /** Returns vehicle list.
    * @return vehicleList */
   public Vehicle[] getVehicleList() {
      return vehicleList;
   }
   
   /** Returns the excluded records.
    * @return excludedRecords */
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
   /** Adds a vehicle to the list.
    * @param vehicleIn for vehicle to be added */
   public void addVehicle(Vehicle vehicleIn) {
      vehicleList = Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = vehicleIn;
   
   }
    
   /** Adds a record to excluded records.
    * @param recordIn for excluded record to be added */
   public void addExcludedRecord(String recordIn) {
      excludedRecords = Arrays.copyOf(excludedRecords, 
         excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = recordIn;
   
   }
    
   /** Creates output of unsorted vehicles.
    * @return output */
   public String toString() {
      String output = "";
      for (Vehicle v : vehicleList) {
         output += "\n" + v + "\n";
      }
      return output;
   }
   
   /** Calculates total use tax.
    * @return totalUT */
   public double calculateTotalUseTax() {
      double totalUT = 0;
      for (Vehicle v : vehicleList) {
         totalUT += v.useTax();
      }
      return totalUT;
   }
   
  /** Calculate total value.
   * @return totalValue */
   public double calculateTotalValue() {
      double totalValue = 0;
      for (Vehicle v : vehicleList) {
         totalValue += v.getValue();
      }
      return totalValue;
   }
   
  /** Creates summary.
   * @return summary */
   public String summary() {
      String summary = "";
      summary += "------------------------------\nSummary for" + taxDistrict
         + "\n------------------------------\n";
      summary += "Number of Vehicles: " + vehicleList.length + 1 + "\n";
      summary += "Total Value: " + calculateTotalValue() + "\n";
      summary += "Total Use Tax: " + calculateTotalUseTax() + "\n\n";
      return summary;
   }
   
  /** Creates list sorted by owner.
   * @return ownerSort */
   public String listByOwner() {
      String ownerSort = "";
      
      return ownerSort;
   }
   
  /** Creates list sorted by use tax.
   * @return useTaxSort */
   public String listByUseTax() {
      String useTaxSort = "";
      
      return useTaxSort;
   }
   
  /** Prints list of excluded records.
   * @return exRList */
   public String excludedRecordsList() {
      String exRList = "";
      
      return exRList;
   }
}