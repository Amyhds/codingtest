def find(x, y):
    stack = [(x, y)]
    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx = x + d[i][0]
            ny = y + d[i][1]
            if 0 <= nx < 16 and 0 <= ny < 16 and maze[nx][ny] == 0:
                stack.append((nx, ny))
                maze[nx][ny] = 1
            elif maze[nx][ny] == 3:
                return 1
    return 0

for _ in range(10):
    T = int(input())
    maze = [list(map(int, input())) for _ in range(16)]
    d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    for i in range(16):
        for j in range(16):
            if maze[i][j] == 2:
                res = find(i, j)
                break
    print(f'#{T} {res}')