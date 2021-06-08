import tCurve.prob as prob

def _integrate(t, n, _f):
    lowBound = 0
    highBound = t
    epsilon = 0.001
    simpsonOld = 0.0
    simpsonNew = epsilon
    s = 4
    while (abs((simpsonNew - simpsonOld)/simpsonNew) > epsilon):
        simpsonOld = simpsonNew
        w = (highBound - lowBound) / s
        pieces = prob._f(lowBound, n)
        for i in range(2, s + 1):
            if i % 2 == 0: 
                pieces = pieces + 4 * prob._f((lowBound + (i-1) * w), n)
            else: pieces = pieces + 2 * prob._f((lowBound + (i-1) * w), n)
        pieces = pieces + prob._f(highBound, n)
        simpsonNew = (w/3) * pieces
        s = s * 2
    return simpsonNew
    
t = 1.8946
n = 7
result = _integrate(t, n, prob._f) 
 
print(result) 