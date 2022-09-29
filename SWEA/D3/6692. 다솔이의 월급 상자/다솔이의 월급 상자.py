T = int(input())
for tc in range(1, T+1):
    N = int(input())
    res = 0
    for _ in range(N):
        p, x = map(float, input().split())
        res += p*x
    print("#{} {:.6f}".format(tc, res))