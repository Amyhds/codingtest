def knapsack(K, N, V, C):
    bag = [[0 for _ in range(K + 1)] for _ in range(N + 1)]
    for i in range(N + 1):
        for v in range(K + 1):
            if i == 0 or v == 0:
                bag[i][v] = 0
            elif V[i - 1] <= v:
                bag[i][v] = max(bag[i - 1][v], C[i - 1] + bag[i - 1][v - V[i - 1]])
            else:
                bag[i][v] = bag[i - 1][v]
    return bag[N][K]

T = int(input())
for tc in range(1, T + 1):
    N, K = map(int, input().split())
    V = []
    C = []
    for _ in range(N):
        v, c = map(int, input().split())
        V.append(v)
        C.append(c)
    print(f'#{tc} {knapsack(K, N, V, C)}')