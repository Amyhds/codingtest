for tc in range(1, 11):
    N = int(input())
    arr = [input() for _ in range(8)]
    res = 0
    #hzt
    for i in range(8):
        for j in range(8-N+1):
            word = ''
            for k in range(N):
                word += arr[i][j+k]
            if word == word[::-1]:
                res += 1
    #vtc
    for i in range(8):
        for j in range(8-N+1):
            word = ''
            for k in range(N):
                word += arr[j+k][i]
            if word == word[::-1]:
                res += 1
    print(f'#{tc} {res}')