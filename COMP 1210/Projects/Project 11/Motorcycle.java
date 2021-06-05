/** Send bobs. 
 * Project 9- Motorcycle
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class Motorcycle extends Vehicle {
   
// Fields
   protected double engSize;
   /** Base tax rate. */
   public static final double TAX_RATE = 0.005;
   /** Tax rate for alternate fuel bikes. */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.0025;
   /** Lower limit for large engine bikes. */
   public static final double LARGE_BIKE_CC_THRESHOLD = 499;
   /** Tax rate for large bikes. */
   public static final double LARGE_BIKE_TAX_RATE = 0.015;
   
// Constructor
   /** Constructs.
    * @param ownerIn for owner
    * @param yearMakeModelIn for yearMakeModel
    * @param valueIn for value
    * @param altFuelIn for altFuel
    * @param engSizeIn for engSize */
   public Motorcycle(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean altFuelIn, double engSizeIn) {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
      engSize = engSizeIn;
   }
   
// Methods
   /** Gets engine size.
    * @return engSize */
   public double getEngineSize() {
      return engSize;
   }
   
   /** Sets engine size.
    * @param engSizeIn for engSize */
   public void setEngineSize(double engSizeIn) {
      engSize = engSizeIn;
   }
    
   /** Calculates cost with tax.
    * @return useTax */
   public double useTax() {
      double useTax = 0;
      if (altFuel) {
         useTax = value * ALTERNATIVE_FUEL_TAX_RATE;
         if (engSize >= LARGE_BIKE_CC_THRESHOLD) {
            useTax += value * LARGE_BIKE_TAX_RATE;
         } 
      } else {
         useTax = value * TAX_RATE;
         if (engSize >= LARGE_BIKE_CC_THRESHOLD) {
            useTax += value * LARGE_BIKE_TAX_RATE;
         }
      }
      return useTax;
   }
    
   /** Creates output.
    * @return result */
   public String toString() {
      String result = super.toString();
      if (altFuel) {
         if (engSize >= LARGE_BIKE_CC_THRESHOLD) {
            result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE
               + " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE;
         } else {
            result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE;
         }
      } else {
         if (engSize >= LARGE_BIKE_CC_THRESHOLD) {
            result += "\nwith Tax Rate: " + TAX_RATE
               + " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE;
         } else {
            result += "\nwith Tax Rate: " + TAX_RATE;
         }
      }
      return result;
   }
}