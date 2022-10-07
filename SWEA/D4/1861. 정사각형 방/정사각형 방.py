from collections import deque
def move(X, Y):
    d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    q = deque([(X, Y)])
    room = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + d[i][0]
            ny = y + d[i][1]
            if 0 <= nx < N and 0 <= ny < N:
                if arr[nx][ny] == arr[x][y] + 1:
                    q.append((nx, ny))
                    room += 1
    return room
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    lst = []
    for i in range(N):
        for j in range(N):
            lst.append((arr[i][j], move(i, j)))
    lst.sort(key = lambda x: (x[1], -x[0]))
    num, cnt = lst.pop()
    print(f'#{tc} {num} {cnt}')
    