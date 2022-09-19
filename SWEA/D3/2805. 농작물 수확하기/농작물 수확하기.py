T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = [input() for _ in range(N)]
    res = ''
    start = N//2
    cnt = 0
    i = 0
    chk = False
    while cnt >= 0:
        res += arr[i][start-cnt:start+cnt+1]
        if cnt == N//2:
            chk = True
        if chk == False:
            cnt += 1
        else:
            cnt -= 1
        i += 1
    ans = 0
    for r in res:
        ans += int(r)
    print(f'#{test_case} {ans}')    
            
        
        
        
    