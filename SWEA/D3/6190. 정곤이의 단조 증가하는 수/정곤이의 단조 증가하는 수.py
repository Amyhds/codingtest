T = int(input())
for tc in range(1, T+1):
    N = int(input())
    A = list(map(int, input().split()))
    lst = []
    res = []
    for i in range(N):
        for j in range(i+1, N):
            lst.append(A[i]*A[j])
    for i in range(len(lst)):
        target = lst[i]
        s_target = str(target)
        if len(s_target) == 1:
            continue
        chk = True
        for j in range(len(s_target)-1):
            if int(s_target[j]) > int(s_target[j+1]):
                chk = False
                break
        if chk == True:
            res.append(target)
    if res:
        print(f'#{tc} {max(res)}')
    else:
        print(f'#{tc} -1')
            
            
            