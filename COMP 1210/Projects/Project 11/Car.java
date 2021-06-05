/** Send bobs. 
 * Project 9- Car
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class Car extends Vehicle {
   
// Fields
   /** Base tax rate. */
   public static final double TAX_RATE = 0.01;
   /** Tax rate for alternate fuel cars. */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.005;
   /** Cheapest luxury car. */
   public static final double LUXURY_THRESHOLD = 50000;
   /** Luxury tax rate. */
   public static final double LUXURY_TAX_RATE = 0.02;
   
// Constructor
   /** Constructs.
    * @param ownerIn for owner
    * @param yearMakeModelIn for yearMakeModel
    * @param valueIn for value
    * @param altFuelIn for altFuel  */
   public Car(String ownerIn, String yearMakeModelIn, double valueIn, 
      boolean altFuelIn) {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
   }
   
// Methods
   /** Calculates the use tax.
    * @return useTax  */
   public double useTax() {
      double useTax = 0;
      if (altFuel) {
         useTax = value * ALTERNATIVE_FUEL_TAX_RATE;
         if (value >= LUXURY_THRESHOLD) {
            useTax += value * LUXURY_TAX_RATE;
         } 
      } else {
         useTax = value * TAX_RATE;
         if (value >= LUXURY_THRESHOLD) {
            useTax += value * LUXURY_TAX_RATE;
         }
      }
      return useTax;
   }
   
   /** Creates output.
    * @return result */
   public String toString() {
      String result = super.toString();
      if (altFuel) {
         if (value >= LUXURY_THRESHOLD) {
            result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE
               + " Luxury Tax Rate: " + LUXURY_TAX_RATE;
         } else {
            result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE;
         }
      } else {
         if (value >= LUXURY_THRESHOLD) {
            result += "\nwith Tax Rate: " + TAX_RATE
               + " Luxury Tax Rate: " + LUXURY_TAX_RATE;
         } else {
            result += "\nwith Tax Rate: " + TAX_RATE;
         }
      }
      return result;
   }
}