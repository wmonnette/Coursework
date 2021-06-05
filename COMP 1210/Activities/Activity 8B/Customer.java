/** Creates customers, sets location, and changes balances. 
 * Activity 8B- Customer
 * @author: Wesley Monnette
 * @version: 11/6/2017 */
public class Customer implements Comparable<Customer> {
   
   // Instance variables
   private String name;
   private String location;
   private double balance;
   
   // Constructor
   /** Customer constructor.
    * @param nameIn for name */
   public Customer(String nameIn) {
      name = nameIn;
      location = "";
      balance = 0;
   }
   
   // Methods
   /** Sets location.
    * @param locationIn */
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /** Sets location.
    * @param city 
    * @param state */
   public void setLocation(String city, String state) {
      location = city + ", " + state;
   }
   
   /** Changes balance.
    * @param amount */
   public void changeBalance(double amount) {
      balance = balance + amount;
   }
   
   /** Gets location.
    * @return location a string */
   public String getLocation() {
      return location;
   }
   
   /** Gets balance.
    * @return balance a double */
   public double getBalance() {
      return balance;
   }
   
   /** Creates output.
    * @return result */
   public String toString() {
      String result = name + "\n" + location + "\n$" + balance;
      return result;
   }
   
   /** Compares customers.
    * @param obj a customer object 
    * @return numbers */
   public int compareTo(Customer obj) {
      if (Math.abs(this.balance - obj.getBalance()) < .000001) {
         return 0;
      }
      else if (this.balance < obj.getBalance()) {
         return -1;
      }
      else {
         return 1;
      }
   }
}