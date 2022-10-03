T = int(input())
for tc in range(1, T+1):
    N = int(input())
    lst = list(map(int, input().split()))
    AVG = int(sum(lst) / N)
    res = 0
    for i in range(N):
        if lst[i] <= AVG:
            res += 1
    print(f'#{tc} {res}')