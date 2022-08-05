def ott(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:
        return ott(n-1) + ott(n-2) + ott(n-3)
    
T = int(input())
for _ in range(T):
    n = int(input())
    print(ott(n))
    
    