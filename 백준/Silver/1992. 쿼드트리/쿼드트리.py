def compress(x, y, N):
    global res
    chk = arr[x][y]
    for i in range(x, x+N):
        for j in range(y, y+N):
            if arr[i][j] != chk:
                new_N = N//2
                res += '('
                compress(x, y, new_N)
                compress(x, y + new_N, new_N)
                compress(x + new_N, y, new_N)
                compress(x + new_N, y + new_N, new_N)
                res += ')'
                return
    if chk == '0':
        res += '0'
        return
    else:
        res += '1'
        return
                    
N = int(input())
arr = [input() for _ in range(N)]
res = ''
whole = 0    
compress(0, 0, N)
print(res)