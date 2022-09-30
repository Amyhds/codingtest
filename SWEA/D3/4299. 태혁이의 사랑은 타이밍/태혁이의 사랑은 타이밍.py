T = int(input())
for tc in range(1, T+1):
    D, H, M = map(int, input().split())
    res = 0
    day = D - 11 
    hour = H - 11
    minute = M - 11
    res += day * 1440 + hour * 60 + minute
    if res < 0:
        res = -1
    print(f'#{tc} {res}')