import java.util.ArrayList;
/** Holds daily temperature.
 * Activity 6- Temperatures
 * @author: Wesley Monnette
 * @version: 10/16/2017 */
 
public class Temperatures {

   // Instance Variables
   private ArrayList<Integer> temperatures;
   
   // Constructor
   /** Creates array to hold temps.
    * @param temperaturesIn for temp */
   public Temperatures(ArrayList<Integer> temperaturesIn) {
      temperatures = temperaturesIn;
   }
   
   // Methods
   /** Gets low temp.
    * @return low */
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 1; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }
   
   /** Gets high temp.
    * @return high */
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         }
      }
      return high;
   }
   
   /** Gets lower minimum.
    * @param lowIn can replace low
    * @return lowIn */
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   
   /** Gets higher maximum.
    * @param highIn can replace high
    * @return highIn */
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
   
   /** Creates output.
    * @return temperatures */
   public String toString() {
      return "\tTemperatures: " + temperatures
         + "\n\tLow: " + getLowTemp()
         + "\n\tHigh: " + getHighTemp();
   }
}