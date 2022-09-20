from collections import deque
def BFS(x, y):
    q = deque([(x, y)])
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < M:
                if arr[nx][ny] == 1:
                    arr[nx][ny] = arr[x][y] + 1
                    q.append([nx, ny])
    return arr[N-1][M-1]
    
N, M = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]
print(BFS(0, 0))