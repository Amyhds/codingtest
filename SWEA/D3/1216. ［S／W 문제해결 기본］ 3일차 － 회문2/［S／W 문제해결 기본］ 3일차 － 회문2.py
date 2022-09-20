for _ in range(10):
    T = int(input())
    h_arr = [input() for _ in range(100)]
    v_arr = [[] for _ in range(100)]
    for i in range(100):
        for j in range(100):
            v_arr[i].append(h_arr[j][i])
    Max = 0
    #h
    for i in range(100):
        for j in range(100):
            for l in range(100-j, 0, -1):
                word = h_arr[i][j:j+l]
                if word == word[::-1] and l > Max:
                    Max = l
    #v            
    for i in range(100):
        for j in range(100):
            for l in range(100-j, 0, -1):
                word = v_arr[i][j:j+l]
                if word == word[::-1] and l > Max:
                    Max = l
    print(f'#{T} {Max}')