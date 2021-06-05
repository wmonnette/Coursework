/**  
 * Project 9- VehiclesPart1.
 * @author: Wesley Monnette
 * @version: 11/26/2017 */
public class VehiclesPart1 {

    /** Driver.
     * @param args not used */
   public static void main(String[] args) {
      Car car1 = new Car("Jones, Sam", "2017 Honda Accord", 22000, false);
      Car car2 = new Car("Jones, Jo", "2017 Honda Accord", 22000, true);
      Car car3 = new Car("Smith, Pat", "2015 Mercedes-Benz Coupe", 110000, 
         false);
      Car car4 = new Car("Smith, Sam", "2015 Mercedes-Benz Coupe", 110000, 
         true);
      
      Truck truck1 = new Truck("Williams, Jo", "2012 Chevy Silverado", 30000, 
         false, 1.5);
      Truck truck2 = new Truck("Williams, Sam", "2010 Chevy Mack", 40000, 
         true, 2.5);
      
      SemiTractorTrailer semi1 = new SemiTractorTrailer("Williams, Pat",
         "2012 International Big Boy", 45000, false, 5.0, 4);
      
      Motorcycle bike1 = new Motorcycle("Brando, Marlon", 
         "1964 Harley-Davidson Sportster", 14000, false, 750); 
   }
}