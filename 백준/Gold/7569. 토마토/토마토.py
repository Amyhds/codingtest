from collections import deque
def isRipe():
    chk = True
    for i in range(H):
        for j in range(N):
            for k in range(M):
                if tomato[i][j][k] == 0:
                    chk = False
                    break
    return chk

def BFS():
    while q:
        z, x, y = q.popleft()
        for i in range(6):
            nz = z + dir[i][0]
            nx = x + dir[i][1]
            ny = y + dir[i][2]
            if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M and tomato[nz][nx][ny] == 0:
                tomato[nz][nx][ny] = tomato[z][x][y] + 1
                q.append((nz, nx, ny))

M, N, H = map(int, input().split())
tomato = [[] for _ in range(H)]
dir = [(0, 0, 1), (0, 0, -1), (0, 1, 0), (0, -1, 0), (1, 0, 0), (-1, 0, 0)]
day = 0
q = deque()
for i in range(H):
    for _ in range(N):
        tomato[i].append(list(map(int, input().split())))

if isRipe():
    day = 0
    print(day)
else:
    for i in range(H):
        for j in range(N):
            for k in range(M):
                if tomato[i][j][k] == 1:
                    q.append((i, j, k))
    BFS()
    if not isRipe():
        day = -1
        print(day)
    else:
        for i in range(H):
            for j in range(N):
                for k in range(M):
                    day = max(day, tomato[i][j][k])
        print(day-1)