def Find(x, y):
    R = 1
    C = 1
    start_x = x
    start_y = y
    # R
    while True:
        x += 1
        if x < N and arr[x][y] != 0 and visited[x][y] == 0:
            R += 1
        else:
            x -= 1
            break
    #C
    while True:
        y += 1
        if y < N and arr[x][y] != 0 and visited[x][y] == 0:
            C += 1
        else:
            y -= 1
            break
    for i in range(start_x, x+1):
        for j in range(start_y, y+1):
            visited[i][j] = 1
    return R, C

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    visited = [[0] * N for _ in range(N)]
    info = []
    for i in range(N):
        for j in range(N):
            if arr[i][j] != 0 and visited[i][j] == 0:
                r, c = Find(i, j)
                info.append((r, c))
    info.sort(key=lambda x: (x[0]*x[1], x[0]))
    print(f'#{tc} {len(info)}', end=' ')
    for i in range(len(info)):
        print(f'{info[i][0]} {info[i][1]}', end=' ')
    print()
