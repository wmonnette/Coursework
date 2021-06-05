/** 
 * Activity 10- OnlineTextItem.
 * @author: Wesley Monnette
 * @version: 11/13/2017 */
 
public abstract class OnlineTextItem extends InventoryItem {
 
 // Constructor
   /** Constructs.
    * @param nameIn for name
    * @param priceIn for price */
   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
 // Methods
   /** Finds cost without tax.
    * @return price */
   public double calculateCost() {
      return price;
   }
   
   
}