import java.io.FileNotFoundException;
/** 
 * Project 10- VehiclesPart2.
 * @author: Wesley Monnette
 * @version: 11/29/2017 */
public class VehiclesPart2 {

    /** Driver.
     * @param args Command Line vehicles1.txt
     * @throws FileNotFoundException for reading */
   public static void main(String[] args) throws FileNotFoundException {
      String fileName = args[0];
      UseTaxList vList = new UseTaxList();
      vList.readVehicleFile(fileName);
      System.out.println(vList.summary());
      System.out.println(vList.listByOwner());
      System.out.println(vList.listByUseTax());
   }
}