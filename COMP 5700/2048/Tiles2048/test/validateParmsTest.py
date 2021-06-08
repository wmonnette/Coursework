'''
Created on Apr 24, 2021

@author: Wesley Monnette
'''
import unittest
import Tiles2048.validateParms as validate


class validateParmsTest(unittest.TestCase):
    # Happy path tests   
    def test100_010_nominalParms(self):
        expected = {'status': 'ok'}
        parms = {'op': 'shift', 'grid': '0220000000000000', 'score': '0', 
                 'direction': 'left', 'integrity': 'B7E22F3B349206BDF0755129CCC9D179E18FB2BB3446ECBA67344FED2E62C8EA'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test100_020_extraParms(self):
        expected = {'status': 'ok'}
        parms = {'op': 'shift', 'grid': '0220000000000000', 'score': '0', 
                 'direction': 'down', 'integrity': 'B7E22F3B349206BDF0755129CCC9D179E18FB2BB3446ECBA67344FED2E62C8EA',
                 'extra': 'parms'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test100_030_directionNotInParms(self):
        expected = {'status': 'ok'}
        parms = {'op': 'shift', 'grid': '0220000000000000', 'score': '0', 
                 'integrity': 'B7E22F3B349206BDF0755129CCC9D179E18FB2BB3446ECBA67344FED2E62C8EA'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)

    # Sad path tests    
    def test900_010_missingGrid(self):
        expected = {'status': 'error: missing grid'}
        parms = {'op': 'shift', 'grid': '', 'score': '0', 'direction': 'down', 
                 'integrity': '2A2EF0D1BEA22B9D6AB67C482BFF954F93F6A3617EF052E11DD8776BFFB7325A'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_011_gridContainsNonInt(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '000000402440202a', 'score': '4', 
                 'direction': 'down', 'integrity': '73BF7B4E7EB347F8D308D42572FD961CAB8E00F462A4641C2B04DDD06385E167'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_012_gridTooShort(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '200200204016', 'score': '0', 
                 'direction': 'down', 'integrity': '68223AFD44B2F5BA22A12E0274A8D5E3B950E8743E8610974FF94EF4907D488F'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_013_gridTooLong(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '00000000020000002', 'score': '0',
                  'direction': 'down', 'integrity': '04830C1C0146B3CED80E1C2EBC8C49A89348891B0EFA1C4430C2AE5A9307F07C'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_014_gridContainsNonValid(self):
        expected = {'status': 'error: invalid grid'}
        parms = {'op': 'shift', 'grid': '2248161632010245120000052', 
                 'score': '4', 'direction': 'down', 'integrity': '4FE79D093988B15DB807B15457386E976C36911BF2D18D640A63814189E69C34'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_020_missingScoreKey(self):
        expected = {'status': 'error: missing score key'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'direction': 'down', 
                 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_021_missingScoreValue(self):
        expected = {'status': 'error: invalid score'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_022_scoreIsNotEven(self):
        expected = {'status': 'error: invalid score'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '33', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_023_scoreIsNotInt(self):
        expected = {'status': 'error: invalid score'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': 'a', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_023_scoreOutOfBounds(self):
        expected = {'status': 'error: invalid score'}
        parms = {'op': 'shift', 'grid': '2222444488881616160', 'score': '98', 
                 'direction': 'down', 'integrity': '796714C3D3D641DB881167DA6ABB6E9EF1D10F07609CECDB2A51CF5C2E2B5ADE'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
    
    def test900_030_missingIntegrityKey(self):
        expected = {'status': 'error: missing integrity key'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'down'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_031_missingIntegrityValue(self):
        expected = {'status': 'error: missing integrity value'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'down', 'integrity': ''}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
            
    def test900_032_integrityNotMatchGrid(self):
        expected = {'status': 'error: invalid integrity value'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'down', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A8'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)
        
    def test900_040_invalidDirection(self):
        expected = {'status': 'error: invalid direction'}
        parms = {'op': 'shift', 'grid': '0000004024402020', 'score': '4', 
                 'direction': 'back', 'integrity': '1875F39BCE84620F9B3273BE921EFF1E541FEAEE10EBBF0858DB30ADF10BE2A9'}
        actual = validate._validateParms(parms)
        self.assertEqual(expected, actual)