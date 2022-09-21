from collections import deque

def BFS(x, y):
    apt = 1
    q = deque([(x, y)]) 
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < N and land[nx][ny] == 1:
                land[nx][ny] = 0
                q.append((nx, ny))
                apt += 1
    return apt
                            
N = int(input())
land = [list(map(int, input())) for _ in range(N)]
res = []
for i in range(N):
    for j in range(N):
        if land[i][j] == 1:
            land[i][j] = 0
            res.append(BFS(i, j))
res.sort()
print(len(res))
for i in range(len(res)):
    print(res[i])