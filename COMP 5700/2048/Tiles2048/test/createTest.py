'''
Created on March 11, 2021

@author: Wesley Monnette
'''
import unittest
import Tiles2048.create as create

class CreateTest(unittest.TestCase):
    def test100_010_nominalCreate(self):
        userParms = {'op': 'create', 'size': '4'}
        actualResult = create._create(userParms)
        self.assertIsNotNone(actualResult)
        
        
## Might come back to finish this but its 11 pm and id rather have working 
# code
    #def test100_010_GridHasTwoTwos(self):
    #    expectedGridSum = 4
    #    userParms = {'op': 'create'}
    #    actualGridSum = create._create(userParms)
    #    actualResult = create._create(userParms)
#    self.assertIsNotNone(actualResult)

    # Test addTwo function
    def test100_010_emptyAddTwo(self):
        gridIn = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
        grid = create._addTwo(gridIn)
        expected = 1
        actual = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    actual += 1
        self.assertEqual(expected, actual)
    
    def test100_020_onlyOneSpace(self):
        gridIn = [[2, 2, 2, 2], [2, 2, 2, 0], [2, 2, 2, 2], [2, 2, 2, 2]]
        grid = create._addTwo(gridIn)
        expected = 16
        actual = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2:
                    actual += 1
        self.assertEqual(expected, actual)
        
    def test110_030_emptyAddTwoFour(self):
        gridIn = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
        grid = create._addTwoFour(gridIn)
        expected = 1
        actual = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 2 or grid[i][j] == 4:
                    actual += 1
        self.assertEqual(expected, actual)
   
    # Test getString function    
    def test120_010_nominalString(self):
        gridMat = [[0, 1024, 512, 256], [128, 64, 32, 16], [8, 4, 2, 0], 
                  [0, 0, 0, 0]]
        expected = '0102451225612864321684200000'
        actual = create._getString(gridMat)
        self.assertEqual(expected, actual)
    
    # Test getMatrix function    
    def test130_010_nominalMatrix(self):
        gridString = '512823216832810246432163210242560'
        expected = [[512, 8, 2, 32], [16, 8, 32, 8], [1024, 64, 32, 16], 
                    [32, 1024, 256, 0]]
        actual = create._getMatrix(gridString)
        self.assertEqual(expected, actual)
    
    # Tests getintegrity function
    def test140_010_nominalIntegrity(self):
        gridString = '512823216832810246432163210242560'
        score = 0
        expected = 'E827EABDF2D3838864A0CB9654083743B7F13F1509E0A878B86C1D3AD85294D1'
        actual = create._getIntegrity(gridString, score)
        self.assertEqual(expected, actual)