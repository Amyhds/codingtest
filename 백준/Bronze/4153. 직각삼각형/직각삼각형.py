while True:
    l = list(map(int, input().split()))
    if l[0]==0:
        break
    M = max(l)
    m = min(l)
    l.remove(M)
    l.remove(m)
    if M**2 == m**2 + l[0]**2:
        print("right")
    else:
        print("wrong")
    
    
        