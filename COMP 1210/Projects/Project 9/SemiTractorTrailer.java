/**  
 * Project 9- SemiTractorTrailer.
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class SemiTractorTrailer extends Truck {
   
// Fields
   protected int axles;
   /** Tax rate for each axle on a semi. */
   public static final double PER_AXLE_TAX_RATE = 0.005;
   
// Constructor
   /** Constructs.
    * @param ownerIn for owner
    * @param yearMakeModelIn for yearMakeModel
    * @param valueIn for value
    * @param altFuelIn for altFuel
    * @param tonsIn for tons 
    * @param axlesIn for axles */
   public SemiTractorTrailer(String ownerIn, String yearMakeModelIn,
      double valueIn, boolean altFuelIn, double tonsIn, int axlesIn) {
      super(ownerIn, yearMakeModelIn, valueIn, altFuelIn, tonsIn);
      axles = axlesIn;
   }
   
// Methods
   /** Gets axles.
    * @return axles */
   public int getAxles() {
      return axles;
   }
   
   /** Sets axles.
    * @param axlesIn for axles */
   public void setAxles(int axlesIn) {
      axles = axlesIn;
   }
    
   /** Calculates cost with tax.
    * @return useTax */
   public double useTax() {
      double useTax = super.useTax();
      useTax += value * PER_AXLE_TAX_RATE * axles;
      return useTax;
   }
    
   /** Creates output.
    * @return result */
   public String toString() {
      String result = super.toString() + " Axle Tax Rate: " 
         + (PER_AXLE_TAX_RATE * axles);
      return result;
   }
}