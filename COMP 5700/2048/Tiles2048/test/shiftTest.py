'''
Created on Apr 19, 2021

@author: Wesley Monnette
'''
import unittest
import Tiles2048.shift as shift
import Tiles2048.create as create

class ShiftTest(unittest.TestCase):
    
# Sad path tests    
    def test900_010_missingGrid(self):
        expected = {'status': 'error: missing grid'}
        parms = {'op': 'shift', 'grid': '', 'score': '0', 'direction': 'down', 
                 'integrity': '2A2EF0D1BEA22B9D6AB67C482BFF954F93F6A3617EF052E11DD8776BFFB7325A'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_011_gridContainsNonInt(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '000000402440202a', 'score': '4', 
                 'direction': 'down', 'integrity': '73BF7B4E7EB347F8D308D42572FD961CAB8E00F462A4641C2B04DDD06385E167'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_012_gridTooShort(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '200200204016', 'score': '0', 
                 'direction': 'down', 'integrity': '68223AFD44B2F5BA22A12E0274A8D5E3B950E8743E8610974FF94EF4907D488F'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_013_gridTooLong(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '00000000020000002', 'score': '0',
                  'direction': 'down', 'integrity': '04830C1C0146B3CED80E1C2EBC8C49A89348891B0EFA1C4430C2AE5A9307F07C'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_014_gridContainsNonValid(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '2248161632010245120000052', 
                 'score': '4', 'direction': 'down', 'integrity': '4FE79D093988B15DB807B15457386E976C36911BF2D18D640A63814189E69C34'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_020_missingScoreKey(self):
        expected = {'status': 'error: missing score key'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'direction': 'down', 
                 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_021_missingScoreValue(self):
        expected = {'status': 'error: invalid score'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_022_scoreIsNotEven(self):
        expected = {'status': 'error: invalid score'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '33', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_023_scoreIsNotInt(self):
        expected = {'status': 'error: invalid score'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': 'a', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
    
    def test900_030_missingIntegrityKey(self):
        expected = {'status': 'error: missing integrity key'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'down'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_031_missingIntegrityValue(self):
        expected = {'status': 'error: missing integrity value'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'down', 'integrity': ''}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
            
    def test900_032_integrityNotMatchGrid(self):
        expected = {'status': 'error: invalid integrity value'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A8'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_040_invalidDirection(self):
        expected = {'status': 'error: invalid direction'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'back', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)
        
    def test900_050_noShiftPossible(self):
        expected = {'status': 'error: no shift possible'}
        parms = {'op': 'shift', 'grid': '2222444488881616162', 'score': '96', 
                 'direction': 'down', 'integrity': '6438AAC0514AC0D656A7C25CFE151E156AB59048AEB589DF58A6AD9AB8E2F641'}
        actual = shift._shift(parms)
        self.assertEqual(expected, actual)

# Happy path tests        
    def test100_010_down(self):
        grid = [[2,0,0,0],[2,0,0,0],[0,0,0,0],[0,0,0,0]]
        score = 0
        actualGrid, actualScore, updated = shift._down(grid, score)
        if actualGrid[3][0] != 4: expected = False
        elif actualScore != 4: expected = False
        else: expected = True 
        self.assertEqual(expected, True)
    
    def test100_011_up(self):
        grid = [[2,0,0,0],[2,0,0,0],[0,0,0,0],[0,0,0,0]]
        score = 0
        actualGrid, actualScore, updated = shift._up(grid, score)
        if actualGrid[0][0] != 4: expected = False
        elif actualScore != 4: expected = False
        else: expected = True
        self.assertEqual(expected, True)
        
    def test100_012_left(self):
        grid = [[2,2,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
        score = 0
        actualGrid, actualScore, updated = shift._left(grid, score)
        if actualGrid[0][0] != 4: expected = False
        elif actualScore != 4: expected = False
        else: expected = True
        self.assertEqual(expected, True)
        
    def test100_013_right(self):
        grid = [[2,2,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
        score = 0
        actualGrid, actualScore, updated = shift._right(grid, score)
        if actualGrid[0][3] != 4: expected = False
        elif actualScore != 4: expected = False 
        else: expected = True
        self.assertEqual(expected, True)
        
    def test100_020_statusWin(self):
        grid = [[2048,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]
        expected = 'win'
        actual = shift._getStatus(grid)
        self.assertEqual(expected, actual)
        
    def test100_021_statusLose(self):
        grid = [[2,4,8,2],[32,64,128,16],[2,4,8,256],[32,64,128,16]]
        expected = 'lose'
        actual = shift._getStatus(grid)
        self.assertEqual(expected, actual)
        
    def test100_022_statusOk(self):
        grid = [[2,2,2,2],[4,4,4,4],[8,8,8,8],[16,16,16,4]]
        expected = 'ok'
        actual = shift._getStatus(grid)
        self.assertEqual(expected, actual)
        
    def test100_030_toOutput(self):
        parms = {'op': 'shift', 'grid': '220044008800161600', 'score': '56', 
                 'direction': 'left', 'integrity': '68A01FFD35BDA1280CBD2928E9BBEA1FB350C8E5B807A282B7151D98C3ED6F2D'}
        
        expected = True
        actual = shift._shift(parms)
        grid = create._getMatrix(actual['grid'])
        calcIntegrity = create._getIntegrity(actual['grid'], actual['score'])
        
        if not('grid' in actual): expected = False
        elif not('score' in actual): expected = False
        elif not('integrity' in actual): expected = False
        elif not(grid[0][0] == 4 and grid[1][0] == 8 and grid[2][0] == 16 
                 and grid[3][0] == 32): expected = False    
        elif not(actual['score'] == '116'): expected = False
        elif not(calcIntegrity == actual['integrity']): expected = False
        self.assertEqual(expected, True)