def DFS(x, y, s):
    s += arr[x][y]
    if len(s) == 7:
        res.add(s)
        return
    for i in range(4):
        nx = x + d[i][0]
        ny = y + d[i][1]
        if 0 <= nx < 4 and 0 <= ny < 4:
            DFS(nx, ny, s)

T = int(input())
for tc in range(1, T+1):
    arr = [list(map(str, input().split())) for _ in range(4)]
    res = set()
    d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    for i in range(4):
        for j in range(4):
            DFS(i, j, '')
    print(f'#{tc} {len(res)}')