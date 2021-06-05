/**  
 * Activity 10- ElectronicsItem.
 * @author: Wesley Monnette
 * @version: 11/13/2017 */
public class ElectronicsItem extends InventoryItem {

// Variables
   protected double weight = 0;
   /** shipping cost constant. */
   public static final double SHIPPING_COST = 1.5;

// Constructor
   /** Constructs.
    * @param nameIn for name
    * @param priceIn for price 
    * @param weightIn for weight */
   public ElectronicsItem(String nameIn, double priceIn, double weightIn) {
      super(nameIn, priceIn);
      weight = weightIn;
   }
   
// Methods
   /** Returns real price.
    * @return cost plus tax and shipping */
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }
}