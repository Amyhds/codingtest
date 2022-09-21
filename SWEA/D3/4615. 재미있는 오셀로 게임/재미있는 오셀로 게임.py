# 답보고 함..
T = int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    board = [[0 for _ in range(N)] for _ in range(N)]
    board[N//2-1][N//2-1] = 2
    board[N//2-1][N//2] = 1
    board[N//2][N//2-1] = 1
    board[N//2][N//2] = 2
    vec = [(1, 0), (1, -1), (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1)]
    for _ in range(M):
        y, x, c = map(int, input().split())
        x -= 1
        y -= 1
        board[x][y] = c
        reverse = []
        for i in range(8) :
            dx, dy = vec[i]
            nx = x + dx
            ny = y + dy
            while True :
                if not (0 <= nx < N and 0 <= ny < N): #범위 벗어나는 경우
                    reverse = []
                    break
                if board[nx][ny] == 0: # 빈 칸일 경우
                    reverse = []
                    break
                if board[nx][ny] == c: # 같은 돌일 경우
                    break
                else: # 조건에 부합하는 돌을 reverse에 추가한다.
                    reverse.append((nx,ny))
                nx, ny = nx + dx, ny + dy # 다음칸가서 또 반복
            for rx, ry in reverse: # 뒤집어준다.
                board[rx][ry] = c
    w, b = 0, 0
    for i in range(N):
        for j in range(N):
            if board[i][j] == 1:
                b += 1
            elif board[i][j] == 2:
                w += 1
    print(f'#{test_case} {b} {w}')
