import sys
input = sys.stdin.readline
def chk(x, y, N):
    global zero, one
    chk_num = paper[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if paper[i][j] != chk_num:
                new = N//2
                chk(x, y, new)
                chk(x, y+new, new)
                chk(x+new, y, new)
                chk(x+new, y+new, new)
                return
    if paper[x][y] == 0:
        zero += 1
    else:
        one += 1
    
N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]
zero = 0
one = 0
chk(0, 0, N)
print(zero)
print(one)