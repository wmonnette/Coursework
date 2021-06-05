import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/** 
 * Activity 8A- BankLoanTest.
 * @author: Wesley Monnette
 * @version: 10/30/2017 */

public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Test for chargeInterest. **/
   @Test public void chargeInterestTest() {
      BankLoan loan1 = new BankLoan("Jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }
}
