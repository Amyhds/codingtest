def tower(idx, total):
    global res
    if idx == N:
        if total >= B:
            res = min(res, total)
            return
        else:
            return
    tower(idx+1, total + height[idx])
    tower(idx+1, total)
    
T = int(input())
for tc in range(1, T+1):
    N, B = map(int, input().split())
    height = list(map(int, input().split()))
    res = 99999999
    tower(0, 0)
    print(f'#{tc} {res - B}')