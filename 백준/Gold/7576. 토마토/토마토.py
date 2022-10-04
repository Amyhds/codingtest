from collections import deque
def isRipe():
    chk = True
    for i in range(N):
        for j in range(M):
            if tomato[i][j] == 0:
                chk = False
                break
    return chk

def BFS():
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dir[i][0]
            ny = y + dir[i][1]
            if 0 <= nx < N and 0 <= ny < M and tomato[nx][ny] == 0:
                tomato[nx][ny] = tomato[x][y] + 1
                q.append((nx, ny))

M, N = map(int, input().split())
tomato = [list(map(int, input().split())) for _ in range(N)]
dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]
day = 0
q = deque()

if isRipe():
    print(day)
else:
    for i in range(N):
        for j in range(M):
            if tomato[i][j] == 1:
                q.append((i, j))
    BFS()
    if not isRipe():
        day = -1
        print(day)
    else:
        for i in range(N):
            for j in range(M):
                day = max(day, tomato[i][j])
        print(day-1)