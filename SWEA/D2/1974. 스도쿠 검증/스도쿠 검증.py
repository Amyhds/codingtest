T = int(input())
for test in range(1, T+1):
    sudoku = [list(map(int, input().split())) for _ in range(9)]
    res = 1
    #horizontal
    for i in range(9):
        if len(set(sudoku[i])) != 9:
            res = 0
            break            
    #vertical
        temp2 = set()
        for j in range(9):
            temp2.add(sudoku[j][i])
        if len(temp2) != 9:
            res = 0
            break                        
    #3*3
    x = 0
    y = 0
    while x <= 6 and y <= 6:
        temp3 = set()
        for i in range(x, x+3):
            for j in range(y, y+3):
                temp3.add(sudoku[i][j])
        if len(temp3) != 9:
            res = 0
            break
        y += 3
        if y > 6:
            y = 0
            x += 3
    print('#'+str(test)+' '+str(res))
            
                  