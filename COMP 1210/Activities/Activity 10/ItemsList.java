/** 
 * Activity 10- ItemList.
 * @author: Wesley Monnette
 * @version: 11/27/2017 */
public class ItemsList {
   
   // Fields
   private InventoryItem[] inventory;
   private int count;
   
   // Constructor
   /** Constructs. */
   public ItemsList() {
      inventory = new InventoryItem[20];
      count = 0;
   }
   
   // Methods
   /** Adds item to inventory array.
    * @param itemIn for item */
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn;
      count++;
   }
   
   /** Finds total price.
    * @param electronicsSurcharge of charge
    * @return total price */
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         }
         else {
            total += inventory[i].calculateCost();
         }
      }
      
      return total;
   }
   
   /** Creates output.
    * @return output */
   public String toString() {
      String output = "All inventory:\n\n";
      for (int i = 0; i < count; i++) {
         output += inventory[i] + "\n";
      }
      return output;
   } 
}