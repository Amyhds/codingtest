for test_case in range(1, 11):
    L = int(input())
    h_arr = [input() for _ in range(8)]
    v_arr = [[] for _ in range(8)]
    for i in range(8):
        for j in range(8):
            v_arr[i].append(h_arr[j][i])
    lst = []
    cnt = 0
    #h
    for i in range(8):
        for j in range(8):
            if j <= 8 - L:
                lst.append(h_arr[i][j:j+L])
    #v            
    for i in range(8):
        for j in range(8):
            if j <= 8 - L:
                lst.append(v_arr[i][j:j+L])
    for word in lst:
        if word == word[::-1]:
            cnt += 1
    print(f'#{test_case} {cnt}')
                
                
    