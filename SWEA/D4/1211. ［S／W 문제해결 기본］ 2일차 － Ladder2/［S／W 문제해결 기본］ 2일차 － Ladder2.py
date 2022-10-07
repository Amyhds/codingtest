from collections import deque

def Find(x, y):
    visited = [[0] * 100 for _ in range(100)]
    d = 0
    while x != 99:
        d += 1
        visited[x][y] += 1
        if y - 1 >= 0 and lad[x][y - 1] and visited[x][y - 1] == 0:
            y -= 1
            continue
        elif y + 1 < 100 and lad[x][y + 1] and visited[x][y + 1] == 0:
            y += 1
            continue
        else:
            x += 1
    return d 

for _ in range(10):
    tc = int(input())
    lad = [list(map(int, input().split())) for _ in range(100)]
    lst = []
    for j in range(100):
        if lad[0][j] == 1:
            dist = Find(0, j)
            lst.append((j, dist))
    lst.sort(key=lambda x : (-x[1], x[0]))
    Y, D = lst.pop()
    print(f'#{tc} {Y}')