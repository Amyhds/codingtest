def put(x, y, c):
    go[x][y] = c
    visit = []
    for i in range(8):
        nx = x + d[i][0]
        ny = y + d[i][1]
        while True :
            if not (0 <= nx < N and 0 <= ny < N): #범위 벗어나는 경우
                visit = []
                break
            if go[nx][ny] == 0: # 빈 칸일 경우
                visit = []
                break
            if go[nx][ny] == c: # 같은 돌일 경우
                break
            else: # 조건에 부합하는 돌을 reverse에 추가한다.
                visit.append((nx,ny))
            nx, ny = nx + d[i][0], ny + d[i][1] # 다음칸가서 또 반복
        for X, Y in visit: # 뒤집어준다.
            go[X][Y] = c
                
T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    go = [[0 for _ in range(N)] for _ in range(N)]
    go[N//2][N//2] = 2
    go[N//2-1][N//2-1] = 2
    go[N//2-1][N//2] = 1
    go[N//2][N//2-1] = 1
    d = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (-1, -1), (-1, 1), (1, -1)]
    white = 0
    black = 0
    for _ in range(M):
        x, y, c = map(int, input().split())
        put(x-1, y-1, c)
    for i in range(N):
        for j in range(N):
            if go[i][j] == 1:
                black += 1
            elif go[i][j] == 2:
                white += 1
    print(f"#{tc} {black} {white}")          