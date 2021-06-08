'''
Created on March 11, 2021

@author: Wesley Monnette
'''

import hashlib
import random
VALID_TILES = ['0','2','4','8','16','32','64','128','256','512','1024']

'''
Parms:     op: create, no other Parms
Function:  Creates a 4x4 grid matrix
           Adds two two's at random places
           Sets score to zero
           Calculates integrity
           Sets status to ok 
Output:    Grid, score, integrity, and status
'''
def _create(userParms):
    
    # Initialize grid as 4x4 matrix
    grid = []
    for i in range(4):
        grid.append([0] * 4)
    
    # Adds a 2 tiles at random place  
    grid = _addTwo(grid)
    grid = _addTwo(grid)
    
    # Sets status, score, and does output
    score = 0
    status = 'ok'
    output = _toOutput(grid, score, status)
    return output

'''
Parms:    Grid matrix
Function: Adds a single two tile at a random, empty tile in the grid
Output:   Grid matrix passed in with an additional two tile
'''
def _addTwo(grid):
    for i in range(1):        
        row = random.randint(0, 3)
        col = random.randint(0, 3)
        while (grid[row][col] != 0):
            row = random.randint(0, 3)
            col = random.randint(0, 3)
        grid[row][col] = 2
    return grid

'''
Parms:    Grid matrix
Function: Adds either a two or four tile at a random, empty tile in the grid
Output:   Grid matrix passed in with an additional two or four tile added
'''
def _addTwoFour(grid):
    for i in range(1):  
        twoFour = random.choice([2,4])    
        row = random.randint(0, 3)
        col = random.randint(0, 3)
        while (grid[row][col] != 0):
            row = random.randint(0, 3)
            col = random.randint(0, 3)
        grid[row][col] = twoFour
    return grid

'''
Parms:    Grid matrix
Function: Converts matrix to string for integrity calculation and output
Output:   Grid string
'''
def _getString(gridMat):
    gridToString = [[str(ele) for ele in sub] for sub in gridMat]
    gridString = ''.join(ele for sub in gridToString for ele in sub)
    return gridString 

'''
Parms:    Grid string
Function: Converts grid string to matrix
Output:   Grid matrix
'''
def _getMatrix(gridString):
    grid = []
    partialGrid = []
    tempTile = ''
    twoTemp = ''
    
    # Pulls valid tiles from gridString    
    for i in range(len(gridString)):
        tempTile = tempTile + gridString[i]
        for j in range(len(VALID_TILES)):
            if tempTile == str(VALID_TILES[j]):
                if tempTile[0] != '2':
                    partialGrid.append(tempTile)
                    tempTile = ''
                # Catches 256 and 2 weirdness    
                elif i + 2 < len(gridString):
                    twoTemp = tempTile + gridString[i+1] + gridString[i+2]
                    if twoTemp[0:3] != '256':
                        partialGrid.append(tempTile)
                        tempTile = ''
                        twoTemp = ''
                    elif tempTile == '256':
                        partialGrid.append(tempTile)
                        tempTile = ''
                        twoTemp = ''
                    else: continue
                else:
                    partialGrid.append(tempTile)
                    tempTile = ''
    
    # Creates integer matrix from grid
    integerGrid = [int(i) for i in partialGrid]
    while integerGrid != []:
        grid.append(integerGrid[:4])
        integerGrid = integerGrid[4:]    
    return grid

'''
Parms:    Grid string, score
Function: Calculates integrity of a grid and score
Output:   Integrity value that matches grid
'''
def _getIntegrity(gridString, score):
    gridString = gridString + '.' + str(score)
    integrity = hashlib.sha256(gridString.encode('utf-8')).hexdigest().upper()
    return integrity

'''
Parms:    Grid matrix, score, and status
Function: Converts matrix to string, calculates integrity, 
            and returns proper output
Output:   Specified output
'''
def _toOutput(gridMatrix, score, status):
    gridString = _getString(gridMatrix)
    integrity = _getIntegrity(gridString, score)
    output = {'grid': gridString, 'score': str(score), 'integrity': integrity, 
              'status': status}
    return output