/**
 * Constructor for users.
 * @author Wesley Monnette
 * @version Sep 25 2017
 */
public class UserInfo {
   // instance variables
   private String firstName;
   private String lastName;
   private String location;
   private int age;
   private int status;
   
   private static final int OFFLINE = 0, ONLINE = 1;
   
   /** 
    * User constructor.
    * @param firstNameIn user's first name.
    * @param lastNameIn user's last name.
    */
   public UserInfo(String firstNameIn, String lastNameIn) {
      firstName = firstNameIn;
      lastName = lastNameIn;
      location = "Not specified";
      age = 0;
      status = OFFLINE;
   }
   
   // methods
   /**
    * toString method.
    * @return output as string
    */
   public String toString() {
      String output = "Name: " + firstName + " "
         + lastName + "\n";
      output += "Location: " + location + "\n";
      output += "Age: " + age + "\n";
      output += "Status: ";
      if (status == OFFLINE) {
         output += "Offline";
      }
      else {
         output += "Online";
      }
      
      return output;
   }
   
   /**
    * Sets user location.
    * @param locationIn user's location
    */
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
    * Sets user age.
    * @param ageIn user's age.
    * @return isSet
    */
   public boolean setAge(int ageIn) {
      boolean isSet = false;
      if (ageIn > 0) {
         age = ageIn;
         isSet = true;
      }
      return isSet;
   }
   
   /**
    * Returns age.
    * @return age
    */
   public int getAge() {
      return age;
   }
   
   /**
    * Returns location.
    * @return location
    */
   public String getLocation() {
      return location;
   }
   
   /**
    * Sets status to offline.
    */
   public void logOff() {
      status = OFFLINE;
   }
   
   /**
    * Sets status to online.
    */
   public void logOn() {
      status = ONLINE;
   }
}
