for _ in range(10):
    t = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    res = []
    D1 = 0
    D2 = 0
    for i in range(100):
        # horizontal
        h = 0
        for j in range(100):
            h += arr[i][j]
        res.append(h)
       # vertical
        v = 0
        for k in range(100):
            v += arr[k][i]
        res.append(v)
        #diagonal
        D1 += arr[i][i]
        D2 += arr[i][99-i]
    res.append(D1)
    res.append(D2)
    MAX = max(res)
    print(f'#{t} {MAX}')
    
            
            