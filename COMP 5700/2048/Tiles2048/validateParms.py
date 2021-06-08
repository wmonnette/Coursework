'''
Created on Apr 22, 2021

@author: Wesley Monnette
'''

import Tiles2048.create as create
DIRECTIONS = ['','up','down','left','right']
VALID_TILES = ['0','2','4','8','16','32','64','128','256','512','1024']

'''
Parms:     User parms: grid, score, direction, and integrity
Function:  Validates parameters from user
Output:    True if parameters are nominal
           Error code and brief description of description 
'''
def _validateParms(userParms):
    result = {'status': 'ok'}
    
    # Validate grid parameters
    if not('grid' in userParms): 
        result = {'status': 'error: missing grid key'}
        return result
    if userParms['grid'] == '': 
        result = {'status': 'error: missing grid'}
        return result
    if not(_isValidGrid(userParms['grid'])): 
        result = {'status': 'error: invalid grid'}
        return result
    if not(_hasEmptyTile(userParms['grid'])):
        result = {'status': 'error: no shift possible'}
        return result    
    
    # Validate score parameters
    if not('score' in userParms):
        result = {'status': 'error: missing score key'}
        return result
    if not(_isValidScore(userParms['grid'], userParms['score'])):
        result = {'status': 'error: invalid score'}
        return result 
    
    # Validate direction parameters
    if ('direction' in userParms):
        if not(userParms['direction'].lower() in DIRECTIONS):
            result = {'status': 'error: invalid direction'}
            return result
    
    # Validate integrity parameters
    if not('integrity' in userParms): 
        result = {'status': 'error: missing integrity key'}
        return result
    if userParms['integrity'] == '':
        result = {'status': 'error: missing integrity value'}
        return result
    if userParms['integrity'] != create._getIntegrity(userParms['grid'], 
                                                   userParms['score']):
        result = {'status': 'error: invalid integrity value'}
        return result
    
    return result
        
'''
Parms:    Grid string, score
Function: Validates if grid is too long, short, or contains invalid characters
          Calculates score based off of tiles passed in
Output:   True if grid is of integer type, is constructed of only valid tiles 
            and has 16 tiles
          False if otherwise  
'''
def _isValidGrid(gridString):
    partialGrid = []
    tempTile = ''
    twoTemp = ''
    numTiles = 0
    
    # Checks for non-integers
    try: int(gridString)
    except: return False
    
    # Pulls valid tiles from gridString    
    for i in range(len(gridString)):
        tempTile = tempTile + gridString[i]
        for j in range(len(VALID_TILES)):
            if tempTile == str(VALID_TILES[j]):
                if tempTile[0] != '2':
                    partialGrid.append(tempTile)
                    tempTile = ''
                    numTiles += 1
                # Catches 256 and 2 weirdness    
                elif i + 2 < len(gridString):
                    twoTemp = tempTile + gridString[i+1] + gridString[i+2]
                    if twoTemp[0:3] != '256':
                        partialGrid.append(tempTile)
                        tempTile = ''
                        twoTemp = ''
                        numTiles += 1
                    elif tempTile == '256':
                        partialGrid.append(tempTile)
                        tempTile = ''
                        twoTemp = ''
                        numTiles += 1
                    else: continue
                else:
                    partialGrid.append(tempTile)
                    tempTile = ''
                    numTiles += 1
    
    # Validates number of tiles and checks for an empty tile                       
    if numTiles != 16: return False
    else: return True
    
'''
Parms:    Grid string
Function: Determines if one or more tiles is open
Output:   Boolean, True if at least one open tile
                   False if no open tile
'''
def _hasEmptyTile(gridString):
    grid = create._getMatrix(gridString)
    emptyTiles = 0
    for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 0:
                    emptyTiles += 1
    if emptyTiles > 0: return True
    else: return False

'''
Parms:       Grid string, score
Function:    Calculates score based off of tiles passed in
Output:      Boolean, True if score is valid for the grid, False if not
'''
def _isValidScore(gridString, score):
    try: int(score)
    except: return False
    if int(score) % 2 != 0: return False
    else: score = int(score)
    tempScore = 0    
    grid = create._getMatrix(gridString)
    for i in range(4):
        for j in range(4):
            if grid[i][j] != 0 and grid[i][j] != 2:
                tempScore += grid[i][j]
    if tempScore < score: return False
    else: return True 