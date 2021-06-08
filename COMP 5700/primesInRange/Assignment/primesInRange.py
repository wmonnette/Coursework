''' 
Created on Apr 27, 2021

@author: Wesley Monnette
'''

'''
Parms:    lowBound and highBound for prime list
Function: Finds all primes between a low and high bound
Output:   List of primes in range
          None if invalid parms or no primes in specified range
'''
def primesInRange(low = None, high = None):
    lowB = 0
    highB = 0
    result = []
    
    # Parameter checking
    if low == None or high == None: return None
    if isinstance(low, int): lowB = int(low)
    elif isInteger(low): lowB = boundToInt(low)
    else: return None
    if isinstance(high, int): highB = int(high)
    elif isInteger(high): highB = boundToInt(high)
    else: return None
    if lowB < 1 or highB > 1000: return None
    elif lowB > highB: return None
    
    # Check primes list for primes between bounds
    for num in range(lowB, highB + 1):
        if num > 1:
            for i in range(2, num):
                if num % i == 0: break
            else: result.append(num)
    return result           

'''
Parms:    Bound as string
Function: Converts string bound to int
Output:   Returns bound if can be int, None if no int found
'''
def boundToInt(boundIn):
    boundOut = ''
    for i in range(len(boundIn)):
        if isInteger(boundIn[i]): boundOut += boundIn[i]
    try: 
        int(boundOut)
        return int(boundOut)
    except: return None
    
'''
Parms:    string char
Function: Checks if char is an integer
Output:   True if string is char, False if not
'''
def isInteger(string):
    error = ''
    if isinstance(string, int): return True
    else:
        for i in range(len(string)):
            try: 
                int(string[i])
                return True
            except: error
        return False
    