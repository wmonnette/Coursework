import javax.swing.JOptionPane;
/** 
 * Activity 11- DivisionDriver.
 * @author: Wesley Monnette
 * @version: 12/4/2017 */
public class DivisionDriver {
   
   /** Drives division.
    * @param args not used */
   public static void main(String[] args) {
      try {
         String numInput 
            = JOptionPane.showInputDialog("Enter the numerator:");
         String denomInput
            = JOptionPane.showInputDialog("Enter the denominator:");
         int num = Integer.parseInt(numInput);
         int denom = Integer.parseInt(denomInput);
         String result = "Integer division: \n"
                    + Division.intDivide(num, denom)
                    + "\n\nFloating point division: \n"
                    + Division.decimalDivide(num, denom);
         JOptionPane.showMessageDialog(null, result, "Result", 
            JOptionPane.PLAIN_MESSAGE);
      }
      catch (NumberFormatException e) {
         JOptionPane.showMessageDialog(null,
            "Invalid input: enter numerical integer values only.",
            "Error", JOptionPane.ERROR_MESSAGE);
      }
      catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e, "Error", 
            JOptionPane.ERROR_MESSAGE);
      }
   }
}