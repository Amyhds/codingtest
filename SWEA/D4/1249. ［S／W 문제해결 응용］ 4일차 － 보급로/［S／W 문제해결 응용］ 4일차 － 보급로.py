from collections import deque

def BFS():
    q = deque()
    q.append((0, 0))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + direct[i][0]
            ny = y + direct[i][1]
            if 0<= nx < N and 0<= ny < N:
                if dist[nx][ny] > dist[x][y] + road[nx][ny]:
                    dist[nx][ny] = dist[x][y] + road[nx][ny]
                    q.append((nx, ny))

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    road = [list(map(int, input())) for _ in range(N)]
    direct= [(0, 1), (0, -1), (1, 0), (-1, 0)]
    dist = [[99999 for _ in range(N)] for _ in range(N)]
    dist[0][0] = 0
    BFS()
    print(f'#{tc} {dist[N-1][N-1]}')