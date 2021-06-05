/**  
 * Project 10- Truck.
 * @author: Wesley Monnette
 * @version: 11/29/2017 */
public class Truck extends Vehicle {
 
 // Fields
   protected double tons;
   /** Base tax rate. */
   public static final double TAX_RATE = 0.02;
   /** Rate for alternate fuel trucks. */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.01;
   /** Bottom limit for large truck. */
   public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0;
   /** Large truck tax rate. */
   public static final double LARGE_TRUCK_TAX_RATE = 0.03;
 
 // Constructor
   /** Constructs.
    * @param ownerIn for owner
    * @param yearMakeModelIn for yearMakeModel
    * @param valueIn for value
    * @param altFuelIn for altFuel
    * @param tonsIn for tons */
   public Truck(String ownerIn, String yearMakeModelIn, double valueIn,
      boolean altFuelIn, double tonsIn) {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn);
      tons = tonsIn;
   }
 
 // Methods
   /** Get tons.
    * @return tons */
   public double getTons() {
      return tons;
   }
    
   /** Set tons.
    * @param tonsIn for tons */
   public void setTons(double tonsIn) {
      tons = tonsIn;
   }
   
   /** Calculates tax cost.
    * @return useTax */
   public double useTax() {
      double useTax = 0;
      if (altFuel) {
         useTax = value * ALTERNATIVE_FUEL_TAX_RATE;
         if (tons >= LARGE_TRUCK_TONS_THRESHOLD) {
            useTax += value * LARGE_TRUCK_TAX_RATE;
         } 
      } else {
         useTax = value * TAX_RATE;
         if (tons >= LARGE_TRUCK_TONS_THRESHOLD) {
            useTax += value * LARGE_TRUCK_TAX_RATE;
         }
      }
      return useTax;
   }
    
   /** Creates output.
    * @return result */
   public String toString() {
      String result = super.toString();
      if (altFuel) {
         if (tons >= LARGE_TRUCK_TONS_THRESHOLD) {
            result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE
               + " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE;
         } else {
            result += "\nwith Tax Rate: " + ALTERNATIVE_FUEL_TAX_RATE;
         }
      } else {
         if (tons >= LARGE_TRUCK_TONS_THRESHOLD) {
            result += "\nwith Tax Rate: " + TAX_RATE
               + " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE;
         } else {
            result += "\nwith Tax Rate: " + TAX_RATE;
         }
      }
      return result;
   }
}