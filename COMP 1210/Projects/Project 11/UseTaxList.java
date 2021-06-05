import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**  
 * Project 11- UseTaxList.
 * @author: Wesley Monnette
 * @version: 11/29/2017 */
public class UseTaxList {
   
   // Fields
   private String taxDistrict;
   private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
   private ArrayList<String> excludedRecords = new ArrayList<String>();
   
   // Constructor
   /** Constructs. */
   public UseTaxList() {
      taxDistrict = "not yet assigned";
      /** maybe some more stuff idk?? */
   }
    
   // Methods
   /** Reads in new vehicle file.
    * @param fileNameIn for fileName
    * @throws FileNotFoundException if no file found */
   public void readVehicleFile(String fileIn) throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileIn));
      taxDistrict = scanFile.nextLine();
      while (scanFile.hasNext()) {
         String line = scanFile.nextLine();
         Scanner scanVehicle = new Scanner(line).useDelimiter(";");
         
         while (scanVehicle.hasNext()) {
            char vehicleType = scanVehicle.next().charAt(0);
            String ownerIn = scanVehicle.next();
            String yearMakeModelIn = scanVehicle.next();
            double valueIn = Double.parseDouble(scanVehicle.next());
            boolean altFuelIn = Boolean.parseBoolean(scanVehicle.next());
            Vehicle v;
         
            try {
               switch (vehicleType) {
                  case 'C':
                     v = new Car(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
                     vehicleList.add(v);
                     break;
               
                  case 'T':
                     double tonsIn = Double.parseDouble(scanVehicle.next());
                     v = new Truck(ownerIn, yearMakeModelIn, valueIn, altFuelIn,
                        tonsIn);
                     vehicleList.add(v);
                     break;
               
                  case 'S':
                     double tonIn = Double.parseDouble(scanVehicle.next());
                     int axlesIn = Integer.parseInt(scanVehicle.next());
                     v = new SemiTractorTrailer(ownerIn, yearMakeModelIn, valueIn, 
                        altFuelIn, tonIn, axlesIn);
                     vehicleList.add(v);
                     break;
               
                  case 'M':
                     double engSizeIn = Double.parseDouble(scanVehicle.next());
                     v = new Motorcycle(ownerIn, yearMakeModelIn, valueIn, altFuelIn,
                        engSizeIn);
                     vehicleList.add(v);   
                     break;
               
                  default:
                     if (scanVehicle.hasNext()) {
                        scanVehicle.nextLine();
                     }
                     break;
               }
            } 
            
            catch (NumberFormatException nfe) {
               if (scanVehicle.hasNext()) {
                  scanVehicle.nextLine();
               }
               String invalid = nfe + " in:\n" + line;
               excludedRecords.add(invalid);
            }
            
            catch (NoSuchElementException nse) {
               if (scanVehicle.hasNext()) {
                  scanVehicle.nextLine();
               }
               String invalid = nse + " in:\n" + line;
               excludedRecords.add(invalid);
            }
            
            catch (NegativeValueException e) {
               if (scanVehicle.hasNext()) {
                  scanVehicle.nextLine();
               }
               String invalid = e + " in:\n" + line;
               excludedRecords.add(invalid);
            }
         }
      }
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
   public ArrayList getVehicleList() {
      return vehicleList;
   }
   
   /** Returns the excluded records.
    * @return excludedRecords */
   public ArrayList getExcludedRecords() {
      return excludedRecords;
   }
   
   /** Adds a vehicle to the list.
    * @param vehicleIn for vehicle to be added */
   public void addVehicle(Vehicle vehicleIn) {
      vehicleList.add(vehicleIn);
   }
    
   /** Adds a record to excluded records.
    * @param recordIn for excluded record to be added */
   public void addExcludedRecord(String recordIn) {
      excludedRecords.add(recordIn);
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
      double totalValue = vehicleList.calculateTotalValue();
      double totalUT = vehicleList.calculateTotalUseTax();
      summary += "------------------------------\nSummary for" + taxDistrict
         + "\n------------------------------\n";
      summary += "Number of Vehicles: " + vehicleList.size() + "\n";
      summary += "Total Value: " + totalValue + "\n";
      summary += "Total Use Tax: " + totalUT + "\n\n";
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