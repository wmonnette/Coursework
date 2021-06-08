/* Wesley Monnette
 * wjm0017
 * P2_wjm0017.cpp
 * Compiled using g++
 * source stuff here
 * g++ -o P2.cpp */

# include <iostream>
# include <stdlib.h>
# include <assert.h>
# include <ctime>
using namespace std;

//prototypes
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
/* Input: A_alive indicates Aaron is alive
 * Input: B_alive indicates Bob is alive
 * Input: C_alive indicates Charlie is alive
 * Return: true if at least two are alive 
 * 		false if otherwise  */

	if (A_alive && B_alive) {
		return true;
	}

	if (A_alive && C_alive) {
		return true;
	}

	if (B_alive && C_alive) {
		return true;
	}

	else {
		return false;
	}
}

void Aaron_shoots1(bool& B_alive, bool& C_alive) {
/* Strategy 1: Use call by reference
 * Input: B_alive indicates whether Bob is alive
 *	  C_alive indicates whether Charlie is alive
 * Return: Change B_alive into false if Bob is killed
 *	   Change C_alive into false if Charlie is killed
 */

	int hit = rand() % 100;
	assert(B_alive || C_alive);
	
	if (C_alive == true) {
		cout << "\t\tAaron is shooting at Charlie\n";
		if (hit <= 33) {
			C_alive = false;
			cout << "\t\tCharlie is dead\n";
		}
		else {
			cout << "\t\tAaron misses\n";
		}
	}
	
	else if (B_alive == true) {
		cout << "\t\tAaron is shooting at Bob\n";
		if (hit <= 33) {
			B_alive = false;
			cout << "\t\tBob is dead\n";
		}
		else {
			cout << "\t\tAaron misses\n";
		}
	}
}

void Bob_shoots(bool& A_alive, bool& C_alive) {
/* Call by reference
 * Input: A_alive indicates if Aaron is alive
 *	  C_alive indicates if Charlie is alive
 * Return: Change A_alive into false if Aaron is killed
 *	   Change C_alive into false if Charlie is killed
 */

	int hit = rand() % 100;
	assert(A_alive || C_alive);

	if (C_alive) {
		cout << "\t\tBob is shooting at Charlie\n";
		if (hit <= 50) {
			cout << "\t\tCharlie is dead\n";
			C_alive = false;
		}
		else {
			cout << "\t\tBob misses\n";
		}
	}
	else if (A_alive) {
		cout << "\t\tBob is shooting at Aaron\n";
		if (hit <= 50) {
			cout << "\t\tAaron is dead\n";
			A_alive = false;
		}
		else {
			cout << "\t\tBob misses\n";
		}
	}
}

void Charlie_shoots(bool& A_alive, bool& B_alive) {
/* Call by reference
 * Input: A_alive indicates if Aaron is alive
 *	  B_alive indicates if Bob is alive
 * Return: Change A_alive into false if Aaron is killed
 * 	   Change B_alive into false if Bob is killed
 */

	assert(A_alive || B_alive);
	if (B_alive == true) {
		cout << "\t\tCharlie is shooting at Bob\n";
		B_alive = false;
		cout << "\t\tBob is dead\n";
	}
	else if (A_alive == true) {
		cout << "\t\tCharlie is shooting at Aaron\n";
		A_alive = false;
		cout << "\t\tAaron is dead\n";
	}
}

void Aaron_shoots2(bool& B_alive, bool& C_alive) {
/* Strategy 2: Use call by reference
 * Input: B_alive indicates if Bob is alive
 * 	  C_alive indicates if Charlie is alive
 * Return: Change B_alive to false if Bob is killed
 *	   Change C_alive to false if Charlie is killed
 */

	int miss = 0;
	int hit = rand() % 100;
	assert(B_alive || C_alive);

	if (B_alive && C_alive && miss < 1) {
		cout << "\t\tAaron intentionally misses his first shot\n";
		cout << "\t\tBoth Bob and Charlie are alive.\n";
		miss++;
	}
	else if (B_alive) {
		cout << "\t\tAaron is shooting at Bob\n";
		if (hit <= 33) {
			cout << "\t\tBob is dead\n";
			B_alive = false;
		}
	else {
		cout << "\t\tAaron misses\n";
	}
	}
	else if (C_alive) {
		cout << "\t\tAaron is shooting at Charlie\n";
		if (hit <= 33) {
			cout << "\t\tCharlie is dead\n";
			C_alive = false;
		}
		else {
			cout << "\t\tAaron misses\n";
		}
	}
}

void test_at_least_two_alive(void) {
/* Test driver for at_least_two_alive() */

cout << "Unit Testing 1: Function - at_least_two_alive() \n";

cout << "Case 1: Aaron alive, Bob alive, Charlie alive\n";
assert (true == at_least_two_alive(true, true, true));
cout << "Case passed..\n";

cout << "Case 2: Aaron dead, Bob alive, Charlie alive\n";
assert (true == at_least_two_alive(false, true, true));
cout << "Case passed...\n";

cout << "Case 3: Aaron alive, Bob dead, Charlie alive\n";
assert (true == at_least_two_alive(true, false, true));
cout << "Case passed...\n";

cout << "Case 4: Aaron alive, Bob alive, Charlie dead\n";
assert (true == at_least_two_alive(true, true, false));
cout << "Case passed...\n";

cout << "Case 5: Aaron dead, Bob dead, Charlie alive\n";
assert (false == at_least_two_alive(false, false, true));
cout << "Case passed...\n";

cout << "Case 6: Aaron dead, Bob alive, Charlie dead\n";
assert (false == at_least_two_alive(false, true, false));
cout << "Case passed...\n";

cout << "Case 7: Aaron alive, Bob dead, Charlie dead\n";
assert (false == at_least_two_alive(true, false, false));
cout << "Case passed...\n";
}

void test_Aaron_shoots1(void) {
/* Test driver for Aaron_shoots1() */
	cout << "Unit Testing 2: Function Aaron_shoots1(B_alive, C_alive)\n";

	cout << "\tCase 1: Bob alive, Charlie alive\n";
	bool b_alive, c_alive = true;
	Aaron_shoots1(b_alive, c_alive);

	cout << "\tCase 2: Bob dead, Charlie alive\n";
	b_alive = false;
	c_alive = true;
	Aaron_shoots1(b_alive, c_alive);

	cout << "\tCase 3: Bob alive, Charlie dead\n";
	b_alive = true;
	c_alive = false;
	Aaron_shoots1(b_alive, c_alive);
}

void test_Bob_shoots(void) {
/* Test driver for Bob_shoots() */
	cout << "Unit Testing 3: Function Bob_shoots(A_alive, C_alive)\n";

	cout << "\tCase 1: Aaron alive, Charlie alive\n";
	bool a_alive, c_alive = true;
	Bob_shoots(a_alive, c_alive);

	cout << "\tCase 2: Aaron dead, Charlie alive\n";
	a_alive = false;
	c_alive = true;
	Bob_shoots(a_alive, c_alive);

	cout << "\tCase 3: Aaron alive, Charlie dead\n";
	a_alive = true;
	c_alive = false;
	Bob_shoots(a_alive, c_alive);
}

void test_Charlie_shoots(void) {
/* Test driver for Charlie_shoots() */
	cout << "Unit Testing 4: Function Charlie_shoots(A_alive, B_alive)\n";
	
	cout << "\tCase 1: Aaron alive, Charlie alive\n";
	bool a_alive, b_alive = true;
	Charlie_shoots(a_alive, b_alive);

	cout << "\tCase 2: Aaron alive, Charlie dead\n";
	a_alive = true;
	b_alive = false;
	Charlie_shoots(a_alive, b_alive);

	cout << "\tCase 3: Aaron dead, Charlie alive\n";
	a_alive = false;
	b_alive = true;
	Charlie_shoots(a_alive, b_alive);
}

void test_Aaron_shoots2(void) {
/* Test driver for Aaron_shoots2() */
	cout << "Unit Testing 5: Function Aaron_shoots2(B_alive, C_alive)\n";
	
	cout << "\tCase 1: Bob alive, Charlie alive\n";
	bool b_alive, c_alive = true;
	Aaron_shoots2(b_alive, c_alive);

	cout << "\tCase 2: Bob alive, Charlie dead\n";
	b_alive = true;
	c_alive = false;
	Aaron_shoots2(b_alive, c_alive);

	cout << "\tCase 3: Bob dead, Charlie alive\n";
	b_alive = false;
	c_alive = true;
	Aaron_shoots2(b_alive, c_alive);
}

int main() {
/* main function */

srand(time(0));
const int RUNS = 10000;
const int A_HIT = 33;
const int B_HIT = 50;
const int C_HIT = 100;
int a_wins_s1, b_wins_s1, c_wins_s1, a_wins_s2, b_wins_s2, c_wins_s2 = 0;

cout << "***Welcome to Wesley's Duel Simulator***\n";

test_at_least_two_alive();
cout << "Press any key to continue...";
cin.ignore().get();

test_Aaron_shoots1();
cout << "Press any key to continue...";
cin.ignore().get();

test_Bob_shoots();
cout << "Press any key to continue...";
cin.ignore().get();

test_Charlie_shoots();
cout << "Press any key to continue...";
cin.ignore().get();

test_Aaron_shoots2();
cout << "Press any key to continue...";
cin.ignore().get();

// Strat 1
cout << "Ready to test strategy 1 (run 10000 times):\n";
cout << "Press any key to continue...";
cin.ignore().get();

a_wins_s1 = 0;
b_wins_s1 = 0;
c_wins_s1 = 0;

for (int i = 0; i < RUNS; i++) {
	bool a_alive = true;
	bool b_alive = true;
	bool c_alive = true;

	while (at_least_two_alive(a_alive, b_alive, c_alive)) {
		if (a_alive) {
			Aaron_shoots1(b_alive, c_alive);
		}
		if (b_alive) {
			Bob_shoots(a_alive, c_alive);
		}
		if (c_alive) {
			Charlie_shoots(a_alive, b_alive);
		}
	}	
	cout << endl;

	if (a_alive) {
		a_wins_s1++;
	}
	else if (b_alive) {
		b_wins_s1++;
	}
	else if (c_alive) {
		c_wins_s1++;
	}
}


// Results stored and printed to terminal
double A_wins_s1 = a_wins_s1 * 1.0 / RUNS;
double B_wins_s1 = b_wins_s1 * 1.0 / RUNS;
double C_wins_s1 = c_wins_s1 * 1.0 / RUNS;

cout << "Aaron won " << a_wins_s1 << "/10000 duels or " << A_wins_s1 * 100 << "%\n";
cout << "Bob won " << b_wins_s1 << "/10000 duels or " << B_wins_s1 * 100 << "%\n";
cout << "Charlie won " << c_wins_s1 << "/10000 duels or " << C_wins_s1 * 100 << "%\n";

// Strat 2
cout << "Ready to test strategy 2 (run 10000 times):\n";
cout << "Press any key to continue...";
cin.ignore().get();
a_wins_s2 = 0;
b_wins_s2 = 0;
c_wins_s2 = 0;

for (int j = 0; j < RUNS; j++) {
	bool a_alive = true;
	bool b_alive = true;
	bool c_alive = true;

	while (at_least_two_alive(a_alive, b_alive, c_alive)) {
		if (a_alive) {
			Aaron_shoots2(b_alive, c_alive);
		}
		if (b_alive) {
			Bob_shoots(a_alive, c_alive);
		}
		if (c_alive) {
			Charlie_shoots(a_alive, b_alive);
		}
	}

	cout << endl;
		
	if (a_alive) {
		a_wins_s2++;
	}
	else if (b_alive) {
		b_wins_s2++;
	}
	else if (c_alive) {
		c_wins_s2++;
	}
}

// Results stored and printed to terminal
double A_wins_s2 = a_wins_s2 * 1.0 / RUNS;
double B_wins_s2 = b_wins_s2 * 1.0 / RUNS;
double C_wins_s2 = c_wins_s2 * 1.0 / RUNS;

cout << "Aaron won " << a_wins_s2 << "/10000 duels or " << A_wins_s2 * 100 << "%\n";
cout <<	"Bob won " << b_wins_s2 << "/10000 duels or " << B_wins_s2 * 100 << "%\n";
cout << "Charlie won " << c_wins_s2 << "/10000 duels or " << C_wins_s2 * 100 << "%\n";

if (A_wins_s2 > A_wins_s1) {
	cout << "Strategy 2 is better than strategy 1.\n";
}
else {
	cout << "Strategy 1 is better than strategy 2.\n";
}

return 0;
}
