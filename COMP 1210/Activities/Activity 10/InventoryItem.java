/** 
 * Activity 10- InventoryItem.
 * @author: Wesley Monnette
 * @version: 11/13/2017 */
public class InventoryItem {

// Variables
   protected String name;
   protected double price;
   private static double taxRate = 0;

// Constructor
   /** Constructs.
    * @param nameIn for name
    * @param priceIn for price */
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
   }
   
// Methods
   /** Returns name.
    * @return name */
   public String getName() {
      return name;
   }
   
   /** Sets tax rate.
    * @param taxRateIn for taxRate */
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }
   
   /** Adds tax to price.
    * @return price with tax */
   public double calculateCost() {
      double cost = price * (1 + taxRate);
      return cost;
   }
   
   /** Returns name and price of item.
    * @return output */
   public String toString() {
      return name + ": $" + calculateCost();
   }
}