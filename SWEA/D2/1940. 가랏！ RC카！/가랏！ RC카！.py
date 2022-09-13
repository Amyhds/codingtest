T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    v = 0
    d = 0
    for _ in range(N):
        ipt = input()
        if len(ipt) > 2:
        	c, a = map(int, ipt.split())
        else:
            c = int(ipt)
        if c == 1:
            v += a
        elif c == 2:
            if v >= a:
                v -= a
            else:
                v = 0
        else:
            v += 0
        d += v
    print('#'+str(test_case)+' '+str(d))
            
            