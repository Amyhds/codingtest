import sys
input = sys.stdin.readline
def chk(x, y, N):
    global res
    chk_num = paper[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if paper[i][j] != chk_num:
                new = N//3
                chk(x, y, new)
                chk(x, y+new, new)
                chk(x, y+new*2, new)
                chk(x+new, y, new)
                chk(x+new, y+new, new)
                chk(x+new, y+new*2, new)
                chk(x+new*2, y, new)
                chk(x+new*2, y+new, new)
                chk(x+new*2, y+new*2, new)
                return
    if chk_num == -1:
        res[0] += 1
    elif chk_num == 0:
        res[1] += 1
    else:
        res[2] += 1
N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]
res = [0, 0, 0]
chk(0, 0, N)
for r in res:
    print(r)