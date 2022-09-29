def five(x, y):
    global res
    for i in range(8):
        cnt = 1
        nx = x + dir[i][0]
        ny = y + dir[i][1]
        while 0<= nx < N and 0<= ny < N:
            if arr[nx][ny] == 'o':
                cnt += 1
                nx += dir[i][0]
                ny += dir[i][1]
            else:
                break
            if cnt == 5:
                res = 'YES'
                return 
              
T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    dir = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (-1, -1), (1, -1), (-1, 1)]
    res = 'NO'
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 'o':
                five(i, j)
    print(f'#{test_case} {res}')
    