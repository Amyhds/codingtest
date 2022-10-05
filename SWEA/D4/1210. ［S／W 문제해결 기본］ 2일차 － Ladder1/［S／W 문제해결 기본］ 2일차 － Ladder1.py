for _ in range(10):
    tc = int(input())
    lad = [list(map(int, input().split())) for _ in range(100)]
    visited = [[0] * 100 for _ in range(100)]
    x = 0
    y = 0
    for i in range(99, -1, -1):
        for j in range(100):
            if lad[i][j] == 2:
                x = i
                y = j
                break
    while x != 0:
        visited[x][y] = 1
        if y - 1 >= 0 and lad[x][y - 1] and visited[x][y - 1] == 0:
            y -= 1
            continue
        elif y + 1 < 100 and lad[x][y + 1] and visited[x][y + 1] == 0:
            y += 1
            continue
        else:
            x -= 1
    print(f'#{tc} {y}')