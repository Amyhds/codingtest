#어렵다! 답보고 함ㅠㅠ
N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
result = []
for i in range(N-7):    #(i,j)는 시작점의 위치!
    for j in range(M-7):
        white = 0
        black = 0
        for x in range(i, i+8):
            for y in range(j, j+8):
                if (x+y) % 2 == 0:
                    if board[x][y] != 'W': #W로 시작했는데 첫번째칸이 W가 아니면 다시 칠해야함
                        white += 1
                    if board[x][y] != 'B':
                        black += 1
                else:
                    if board[x][y] != 'B': #W로 시작했는데 두번째칸이 B가 아니면 다시 칠해야함
                        white += 1
                    if board[x][y] != 'W':
                        black += 1
        result.append(white)
        result.append(black)
print(min(result))