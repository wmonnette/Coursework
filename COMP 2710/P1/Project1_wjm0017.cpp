/* Wesley Monnette
 * wjm0017
 * Project1_wjm0017.cpp
 * Did not compile, I have been on vacation and unable to figure out how to upload my files to the linux server.
 * g++ -o Project1_wjm0017.cpp
 */
 // Multiple sources to figure out scp but I still can not figure it out.
 // Serveral sources to learn the setw() function.

#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    
	// Variables
	double initialLoan;
	double loanBalance;
	double intRateIn;
	double intRate;
	double payment;
	double monthlyRate;
	double interestAmount;
	double principal;
	double totalInterest;
	int numMonths = 0;

	// Formatting
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);
	std::left;

	// Input Stream
	cout << "Loan Amount: ";
	cout << "\nInterest Rate (% per year): ";
	cout << "\nMonthly Payments: ";
	cin >> initialLoan >> intRateIn >> payment;

	// Creates output
	cout << "*********************************************************************" << "\n\tAmortization Table" << "\n*********************************************************************";
	
	// Initialization of variables
	loanBalance = initialLoan;
	intRate = intRateIn / 100;
	monthlyRate = (intRate/ 12);
	
	// Table formatting
	std::cout << "\n" std::setw(10) << "Month" << "Balance" << "Payment" << "Rate" << "Interest" << "Principal";
	

	// Calculates balance, principal payments, interest, and how long it will take to pay off.
	if (payment <=  monthlyInterest) {
		cout << "\nPayments must be larger than monthly interest\n";	
	}

	while (loanBalance > 0) {
		// More formatting for table
		cout << setw(10);

		// Interest for the month
		interestAmount = (loanBalance * monthlyRate);

		//Principal payment towards loan
		principal = payment - interestAmount;

		//New loan balance
		loanBalance = loanBalance - principal;
		totalInterest += interestAmount;
		++numMonths;

		if (loanBalance <= 0) {
			principal = loanBalance + principal;
			payment = principal + interestAmount;
			loanBalance = 0;
		}

		cout << "\n" << numMonths << "$" loanBalance << "$" payment << intRate 
			 << "$" interestAmount << "$" principal;
	
	}

	cout << "\n*********************************************************************" << "\n\nIt takes " << numMonths
         << " months to pay off the loan." << "\nTotal interest paid is: $" << totalInterest << "\n";
	return 0;
}
