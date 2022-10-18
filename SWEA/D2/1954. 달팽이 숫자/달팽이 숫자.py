T = int(input())
for tc in range(1, T+1):
    N = int(input())
    d = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    arr = [[0]*N for _ in range(N)]
    x = 0
    y = -1
    n = 1
    k = 0
    while n <= N*N:
        nx = x + d[k][0]
        ny = y + d[k][1]
        if 0 <= nx < N and 0 <= ny < N and arr[nx][ny] == 0:
            arr[nx][ny] = n
            n += 1
            x = nx
            y = ny
        else:
            k = (k+1) % 4
    print(f'#{tc}')
    for i in range(N):
        print(*arr[i])
        