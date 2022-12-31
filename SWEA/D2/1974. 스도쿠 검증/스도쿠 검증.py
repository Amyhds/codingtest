T = int(input())
for tc in range(1, T+1):
    sudoku = [list(map(int, input().split())) for _ in range(9)]
    res = 1
    #hzt
    for i in range(9):
        chk = [0] * 9
        for j in range(9):
            chk[sudoku[i][j] - 1] = 1
        if sum(chk) != 9:
            res = 0
            break
    #vtc
    if res == 1:
        for i in range(9):
            chk = [0] * 9
            for j in range(9):
                chk[sudoku[j][i] - 1] = 1
            if sum(chk) != 9:
                res = 0
                break
    #3*3
    if res == 1:
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                chk = [0] * 9
                for x in range(3):
                    for y in range(3):
                        chk[sudoku[i+x][j+y] - 1] = 1
                if sum(chk) != 9:
                    res = 0
                    break
    print(f'#{tc} {res}')