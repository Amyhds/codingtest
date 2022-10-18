T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    res = []
    if N > M:
        b = N
        s = M
        big = list(map(int, input().split()))
        sml = list(map(int, input().split()))
    else:
        b = M
        s = N
        sml = list(map(int, input().split()))
        big = list(map(int, input().split()))
    for i in range(b-s+1):
        temp = 0
        for j in range(s):
            temp += sml[j] * big[i+j]
        res.append(temp)
    print(f'#{tc} {max(res)}')
        