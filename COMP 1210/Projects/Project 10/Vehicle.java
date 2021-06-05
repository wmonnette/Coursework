import java.text.DecimalFormat;

/**
 * Project 10- Vehicle.
 * @author: Wesley Monnette
 * @version: 11/29/2017 */
public abstract class Vehicle implements Comparable<Vehicle> {
 
 // Fields
   protected String owner;
   protected String yearMakeModel;
   protected double value;
   protected boolean altFuel;
   private static int vehicleCount;
 
// Constructor
   /** Constructs.
    * @param ownerIn for owner
    * @param yearMakeModelIn for yearMakeModel
    * @param valueIn for value
    * @param altFuelIn for altFuel */
   public Vehicle(String ownerIn, String yearMakeModelIn, double valueIn,
      boolean altFuelIn) {
      owner = ownerIn;
      yearMakeModel = yearMakeModelIn;
      value = valueIn;
      altFuel = altFuelIn;
      vehicleCount++;
   }
   
// Methods
   /** Returns owner.
    * @return owner */
   public String getOwner() {
      return owner;
   }
   
   /** Sets owner.
    * @param ownerIn for owner */
   public void setOwner(String ownerIn) {
      owner = ownerIn;
   }
   
   /** Returns year make and model.
    * @return yearMakeModel */
   public String getYearMakeModel() {
      return yearMakeModel;
   }
   
   /** Sets year make and model.
    * @param yearMakeModelIn for yearMakeModel */
   public void setYearMakeModel(String yearMakeModelIn) {
      yearMakeModel = yearMakeModelIn;
   }
   
   /** Gets value.
    * @return value */
   public double getValue() {
      return value;
   }
   
   /** Sets value.
    * @param valueIn for value */
   public void setValue(double valueIn) {
      value = valueIn;
   }
   
   /** Gets alternative fuel.
    * @return altFuel */
   public boolean getAlternativeFuel() {
      return altFuel;
   }
   
   /** Sets alternative fuel.
    * @param altFuelIn for altFuel */
   public void setAlternativeFuel(boolean altFuelIn) {
      altFuel = altFuelIn;
   }
   
   /** Gets vehicle count.
    * @return vehicleCount */
   public static int getVehicleCount() {
      return vehicleCount;
   }
   
   /** Resets vehicle count. */
   public static void resetVehicleCount() {
      vehicleCount = 0;
   }
   
   /** Finds tax for using vehicle.
    * @return useTax */
   public abstract double useTax();
   
   /** Creates output.
    * @return result */
   public String toString() {
      DecimalFormat df1 = new DecimalFormat("$#,##0.00");
      String result = owner + ": " + this.getClass().toString().substring(6) 
         + " " + yearMakeModel;
      if (altFuel) {
         result += " (Alternative Fuel)";  
      }
      result += "\nValue: " + df1.format(value) + " Use Tax: " 
         + df1.format(useTax());
      return result;
   }
   
   /** Compares vehicle objects.
    * @param vehicleIn for vehicle
    * @return result */
   public int compareTo(Vehicle vehicleIn) {
      int result;
      String lastName = "";
      String firstName = "";
      String[] names = owner.split("\\s");
      lastName = names[1];
      firstName = names[0];
      String fullName = lastName + firstName;
      
      String lastNameIn = "";
      String firstNameIn = "";
      String[] namesIn = vehicleIn.owner.split("\\s");
      lastNameIn = namesIn[1];
      firstNameIn = namesIn[0];
      String fullNameIn = lastNameIn + firstNameIn;
      result = fullName.toLowerCase().compareTo(fullNameIn.toLowerCase());
      return result;
   }
}