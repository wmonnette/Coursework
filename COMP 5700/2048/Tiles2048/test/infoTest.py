'''
Created on March 11, 2021

@author: Wesley Monnette
'''
import unittest
import Tiles2048.info as info


class InfoTest(unittest.TestCase):

    def test100_010_ShouldReturnMyUserName(self):
        expected = {'user': 'wjm0017'}
        userParms = {'op': 'info'}
        actual = info._info(userParms)
        self.assertDictEqual(expected, actual)