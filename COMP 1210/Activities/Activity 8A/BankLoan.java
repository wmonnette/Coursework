/**
 * Activity 8A- BankLoan.
 * @author: Wesley Monnette
 * @version: 10/30/2017 */
public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   private static int loansCreated = 0;

// Constructor
/** Bank loan constructor.
 * @param customerNameIn for customerName
 * @param interestRateIn for interestRate */
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }

// Methods
/** Borrows from bank.
 * @param amount 
 * @return wasLoanMade */
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }

/** Pays the bank.
 * @param amountPaid
 * @return newBalance */
   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }

/** Returns balance.
 * @return balance */   
   public double getBalance() {
      return balance;
   }

/** Sets interest rate.
 * @param interestRateIn for interestRate
 * @return true or false */   
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }

/** Returns IR.
 * @return interestRate */   
   public double getInterestRate() {
      return interestRate;
   }

/** Charges interest. */   
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }

/** toString for output.
 * @return output */   
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }
   
// New methods

/** Validates amount.
 * @param amount  
 * @return true or false */   
   public static boolean isAmountValid(double amount) {
      return amount >= 0;
   }

/** Determines if loan holder has a balance.
 * @param loan of BankLoan
 * @return true or false */   
   public static boolean isInDebt(BankLoan loan) {
      if (loan.getBalance() > 0) {
         return true;
      }
      return false;
   }

/** Returns all loans created.
 * @return loansCreated */  
   public static int getLoansCreated() {
      return loansCreated;
   }

/** Resets loans to 0. */   
   public static void resetLoansCreated() {
      loansCreated = 0;
   }
}
