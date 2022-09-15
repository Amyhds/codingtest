T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    snail = [[0 for _ in range(N)] for _ in range(N)]
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    x = 0
    y = -1
    cnt = 1
    k = 0
    while cnt <= N*N:
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < N and 0 <= ny < N and snail[nx][ny] == 0:
            snail[nx][ny] = cnt
            cnt += 1
            x = nx
            y = ny
        else:
            k = (k+1)%4

    print('#' + str(test_case))
    for i in range(N):
        print(*snail[i])