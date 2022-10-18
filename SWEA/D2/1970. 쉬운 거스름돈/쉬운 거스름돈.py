money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    res = [0] * 8
    for i in range(8):
        res[i] += N // money[i]
        N = N - res[i] * money[i]
    print(f'#{tc}')
    print(*res)