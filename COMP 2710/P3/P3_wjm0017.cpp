/* Wesley Monnette
 * wjm0017
 * P3_wjm0017.cpp
 * Compiled with g++
 * 
 * g++ P3_wjm0017.cpp
 */

#include <fstream>
#include <iostream>
#include <cstdlib>
#include <string>
#include <cassert>

using namespace std;

const int MAX_SIZE = 100;

// Input: 1. Array storing data retrieved from the file (i.e., instream)
// 	  2. input file stream object
// Output: Array size
int readFile (int inputArray[], ifstream& instream) {
	int index = 0;
	instream >> inputArray[index];

	while (!instream.eof()) {
		index++;
		instream >> inputArray[index];
	}

	return index;
}

// Input: 1. Array of combined data from two input files.
// 	  2. Output array size
// Output: Creates output file containg the sorted array
void writeFile(int oArray[], int oArraySize, ofstream& outstream) {
	
	for (int i = 0; i < oArraySize; i++) {
		outstream << oArray[i] << endl;
	}
}

// Input: 1. Array storing data retrieved from file
//   	  2. Array size retrieved from file
//  	  3. Array storing data retrieved from file
//  	  4. Array size retrieved from file
//  	  5. Array used to save output data
// Output: Sorted list of numbers from both files
int sort(int i1Array[], int i1ArraySize, int i2Array[], int i2ArraySize, int oArray[]) {
	
	int outputSize = i1ArraySize + i2ArraySize;
	int index1, index2, index3;
	index1 = index2 = index3 = 0;

	while (index1 < i1ArraySize && index2 < i2ArraySize) {
		if (i1Array[index1] < i2Array[index2]) {
			oArray[index3] = i1Array[index1];
			index1++;
			index3++;
		}
		else {
			oArray[index3] = i2Array[index2];
			index2++;
			index3++;
		}
	}

	if(index1 == i1ArraySize) {
		while (index2 < i2ArraySize) {
			oArray[index3] = i2Array[index2];
			index2++;
			index3++;
		}
	}
	else {
		while(index1 < i1ArraySize) {
			oArray[index3] = i1Array[index1];
			index1++;
			index3++;
		}
	}

	assert(index3 == outputSize);
	return outputSize;
}

// Tests readFile()
void test_readFile(void) {
	ifstream instream;
	int array[100];
	int arraySize;

	std::string input1 = "input1.txt";
	std::string input2 = "input2.txt";

	cout << "Unit Test Case 1: readFile()\n";
	cout << "\tCase 1.1: input1.txt - 4 values\n";
	instream.open(input1.c_str());
	int int1 = readFile(array, instream);
	assert(int1);
	instream.close();
	
	cout << "\tCase 1.1 passed.\n";

	cout << "\tCase1.2: input2.txt - 6 values\n";
	instream.open(input2.c_str());
	int int2 = readFile(array, instream);
	assert(int2);
	instream.close();
	cout << "\tCase 1.2 passed.\n";
}

// Test sort()
void test_sort(void) {
	ifstream instream;
	int iArray[100], i2Array[100], oArray[100];
	int a1Size, a2Size, a3Size;
	std::string file1 = "input1.txt";
	std::string file2 = "input2.txt";

	cout << "Unit Test Case 2: sort()\n";

	instream.open(file1.c_str());
	a1Size = readFile(iArray, instream);
	instream.close();
	instream.open(file2.c_str());
	a2Size = readFile(i2Array, instream);
	instream.close();
	
	cout << "\tCase 2.1: input1.txt, input2.txt\n";
	int sort1 = sort(iArray, a1Size, i2Array, a2Size, oArray);
	assert(sort1);
	cout << "\tCase 2.1 passed.\n";
}

int main () {
	test_readFile();
	cout << "Press any key to continue...";
	cin.ignore().get();

	test_sort();
	cout << "Press any key to continue...";
	cin.ignore().get();

	ifstream instream;
	ofstream outstream;
	int data;
	int stream_a1Size;
	int stream_a2Size;
	int oArraySize;

	int i1Array[100];
	int i2Array[100];
	int oArray[100];

	std::string file1 = "";
	std::string file2 = "";
	std::string outputFile = "";

	string outputFileName;
	string fileName;

	cout << "*** Welcome to Wesley's sorting program ***" << endl;
	cout << "Enter the first input file name: ";
	cin >> fileName;

	instream.open((char *) fileName.c_str());
	if (instream.fail()) {
		cout << "Input file opening failed." << endl;
		exit(1);
	}

	stream_a1Size = readFile(i1Array, instream);
	cout << "The list of " << stream_a1Size << " numbers in file " << fileName << " is:\n";

	while(!instream.eof()) {
		cout << data << endl;
		instream >> data;
	}

	for (int i = 0; i <= stream_a1Size; i++) {
		cout << i1Array[i] << "\n";
	}
	instream.close();
	instream.clear();

	cout << "\nEnter the second input file name: ";
	cin >> fileName;

	instream.open((char *) fileName.c_str());
	if (instream.fail()) {
		cout << "Input file opening failed." << endl;
		exit(1);
	}

	stream_a2Size = readFile(i2Array, instream);
	cout << "The list of " << stream_a2Size << " numbers in file " << fileName << " is:\n";
	
	while (!instream.eof()) {
		cout << data << endl;
		instream >> data;
	}
	
	for (int i = 0; i < stream_a2Size; i++) {
		cout << i2Array[i] << "\n";
	}

	instream.close();
	instream.clear();

	cout << "\n";
	oArraySize = sort(i1Array, stream_a1Size, i2Array, stream_a2Size, oArray);
	cout << "The sorted list of " << oArraySize << " numbers is: ";
	for (int i = 0; i < oArraySize; i++) {
		cout << oArray[i] << " ";
	}


	cout << "\nEnter the output file name: ";
	cin >> outputFileName;
	outstream.open((char *) outputFileName.c_str());
	
	if (outstream.fail()) {
		cout << "Output file opening failed.";
		exit(1);
	}

	writeFile(oArray, oArraySize, outstream);
	
	cout << "*** Please check the new file - " << outputFileName << " ***\n";
	cout << "*** Goodbye ***";

	return 0;
}
