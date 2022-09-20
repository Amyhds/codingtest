def recur(N, M):
    if M == 0:
        return 1
    M -= 1
    return N * recur(N, M)

for _ in range(10):
    T = int(input())
    N, M = map(int, input().split())
    res = recur(N, M)
    print(f'#{T} {res}')
    