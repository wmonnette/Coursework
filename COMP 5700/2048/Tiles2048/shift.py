'''
Created on April 19, 2021

@author: Wesley Monnette
'''

import Tiles2048.create as create
import Tiles2048.validateParms as validate

'''
Parms:    User defined parms
Function: If given valid parms, will shift grid according to user's choice
            defaults to down if no direction given
Output:   Shifted grid with a 2 tile added, score updated, integrity updated,   
'''
def _shift(userParms):
    grid = []
    score = 0
    direction = ''
    
    gridOut = []
    scoreOut = 0
    
        
    # Validates parameters and if all is Gucci, assigns parms to variables
    validParms = validate._validateParms(userParms)
    if 'error' in validParms['status']: return validParms
    else:
        # Create variables for shift
        grid = create._getMatrix(userParms['grid'])
        score = int(userParms['score'])
        if not('direction' in userParms) or userParms['direction'] == '':
            direction = 'down'
        else: direction = userParms['direction'].lower()
    if direction == 'down': gridOut, scoreOut, updated = _down(grid, score)   
    elif direction == 'up': gridOut, scoreOut, updated = _up(grid, score)    
    elif direction == 'left': gridOut, scoreOut, updated = _left(grid, score)   
    elif direction == 'right': gridOut, scoreOut, updated = _right(grid, score)

    gridOut = create._addTwoFour(gridOut)
    status = _getStatus(gridOut)
    output = create._toOutput(gridOut, scoreOut, status)
    return output

'''
Parms:    Grid matrix, score
Function: Shifts grid down
Output:   Shifted grid matrix, score, updated boolean
'''
def _down(grid, score):
    gridOut = _transpose(grid)
    gridOut, score, updated = _right(gridOut, score)
    gridOut = _transpose(gridOut)
    return gridOut, score, updated

'''
Parms:    Grid matrix, score
Function: Shifts grid up
Output:   Shifted grid matrix, score, updated boolean
'''
def _up(grid, score):
    gridOut = _transpose(grid)
    gridOut, score, updated = _left(gridOut, score)
    gridOut = _transpose(gridOut)
    return gridOut, score, updated

'''
Parms:    Grid matrix, score
Function: Shifts grid to the left
Output:   Shifted grid matrix, score, updated boolean
'''
def _left(grid, score):
    gridOut, compressUpdated = _compress(grid)
    gridOut, score, mergeUpdated = _merge(gridOut, score)
    updated = compressUpdated or mergeUpdated
    gridOut, temp = _compress(gridOut) 
    return gridOut, score, updated

'''
Parms:    Grid matrix, score
Function: Shifts grid to the right
Output:   Shifted grid matrix, score, updated boolean
'''
def _right(grid, score):
    gridOut = _reverse(grid)
    gridOut, score, updated = _left(gridOut, score)
    gridOut = _reverse(gridOut)
    return gridOut, score, updated

'''
Parms:    Grid matrix
Function: Reverses the content of each row
Output:   Reversed grid matrix
'''        
def _reverse(grid):
    gridOut = []
    for i in range(len(grid)):
        gridOut.append([])
        for j in range(len(grid[0])):
            gridOut[i].append(grid[i][len(grid[0])-j-1])
    return gridOut

'''
Parms:    Grid matrix
Function: Interchange rows and column
Output:   Transposed grid matrix
'''
def _transpose(grid):
    gridOut = []
    for i in range(4):
        gridOut.append([])
        for j in range(4):
            gridOut[i].append(grid[j][i])
    return gridOut

'''
Parms:    Grid matrix
Function: Compresses the grid before merging cells
Output:   Compressed grid and updated boolean
'''
def _compress(grid):
    updated = False
    gridOut =[]
    
    # Creates empty grid
    for i in range(4):
        gridOut.append([0]*4)
    
    for i in range(4):
        index = 0
        for j in range(4):
            if grid[i][j] != 0:
                gridOut[i][index] = grid[i][j]
                if (j != index):
                    updated = True 
                index += 1
    return gridOut, updated
        
'''
Parms:    Grid matrix, score
Function: Merges tiles that need merging and updates the score
Output:   new merged grid matrix, score, and updated boolean
'''
def _merge(grid, score):
    updated = False
    
    for i in range(4):
        for j in range(3):
            # If current cell has the same value as adjacent cell 
            # and aren't empty, merge them and update score
            if grid[i][j] == grid[i][j+1] and grid[i][j] != 0:
                tile = grid[i][j]
                grid[i][j] = grid[i][j] * 2
                grid[i][j+1] = 0
                score = score + tile*2
                updated = True
    return grid, score, updated

'''
Parms:    Shifted grid matrix
Function: Checks if player has won, lost, or can continue play
Output:   status: win, status: lose, status: ok respectively
'''
def _getStatus(grid):
    result = ''
    # Checks for win
    for i in range(4):
        for j in range(4):
            if grid[i][j] == 2048:
                result = 'win'
                return result
    
    # Checks for zero
    for i in range(4):
        for j in range(4):
            if grid[i][j] == 0:
                result = 'ok'
                return result
    
    # Checks for adjacent tiles so play can continue
    for i in range(3):
        for j in range(3):
            if grid[i][j] == grid[i+1][j] or grid[i][j] == grid[i][j+1]:
                result = 'ok'
                return result
    for k in range(3):
        if grid[3][k] == grid[3][k+1]:
            result = 'ok'
            return result
    for l in range(3):
        if grid[l][3] == grid[l+1][3]:
            result = 'ok'
            return result        
    result = 'lose'
    return result