''' 
Created on Apr 27, 2021

@author: Wesley Monnette
'''

import unittest
import Assignment.primesInRange as pIR

class PrimeInRangeTest(unittest.TestCase):

    def setUp(self):
        pass

    def tearDown(self):
        pass

# Sample happy path test
    def test100_010_nominalRange(self):
        lowBound = 2
        highBound = 10
        expectedResult = [2, 3, 5, 7]
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertListEqual(expectedResult, actualResult)
        
    def test100_020_boundIsStrings(self):
        lowBound = "lowBound=950"
        highBound = "highBound=1000"
        expectedResult = [953, 967, 971, 977, 983, 991, 997]
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertListEqual(expectedResult, actualResult)
        
    def test100_030_LowEqualHigh(self):
        lowBound = 11
        highBound = 11
        expectedResult = [11]
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertListEqual(expectedResult, actualResult)
        
    def test100_040_noPrime(self):
        lowBound = 14
        highBound = 16
        expectedResult = []
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertListEqual(expectedResult, actualResult)
        
# Sad paths
    def test900_010_LowBoundOutOfRange(self):
        lowBound = 0
        highBound = 3
        expectedResult = None
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertEqual(expectedResult, actualResult)
        
    def test900_011_HighBoundOutOfRange(self):
        lowBound = 1000
        highBound = 1001
        expectedResult = None
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertEqual(expectedResult, actualResult)
        
    def test900_020_RangeIsBackwards(self):
        lowBound = 40
        highBound = 5
        expectedResult = None
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertEqual(expectedResult, actualResult)
    
    def test900_030_CharInput(self):
        lowBound = 'a'
        highBound = 18
        expectedResult = None
        actualResult = pIR.primesInRange(lowBound, highBound)
        self.assertEqual(expectedResult, actualResult)
        
    def test900_040_NoInput(self):
        expectedResult = None
        actualResult = pIR.primesInRange()
        self.assertEqual(expectedResult, actualResult)
        