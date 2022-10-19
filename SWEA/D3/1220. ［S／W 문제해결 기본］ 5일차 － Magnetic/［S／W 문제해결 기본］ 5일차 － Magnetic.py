for tc in range(1, 11):
    N = int(input())
    table = [list(input().split()) for _ in range(100)]
    cnt = 0
    for i in range(100):
        chk = ''
        for j in range(100):
            if table[j][i] != '0':
                chk += table[j][i]
        for k in range(len(chk)):
            if chk[k:k+2] == '12':
                cnt += 1
    print(f'#{tc} {cnt}')        