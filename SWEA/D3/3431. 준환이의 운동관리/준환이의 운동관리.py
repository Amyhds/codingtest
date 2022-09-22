T = int(input())
for test_case in range(1, T+1):
    L, U, X = map(int, input().split())
    res = 0
    if X < L:
        res = L - X
    elif X > U:
        res = -1
    elif L < X < U:
        res = 0
    print(f'#{test_case} {res}')