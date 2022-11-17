def knapsack(volume, cost):
    bag = [[0 for _ in range(K + 1)] for _ in range(N + 1)]
    for i in range(1, N + 1):
        for j in range(1, K + 1):
            if volume[i - 1] <= j:
                bag[i][j] = max(bag[i - 1][j], cost[i - 1] + bag[i - 1][j - volume[i - 1]])
            else:
                bag[i][j] = bag[i - 1][j]
    return bag[N][K]

T = int(input())
for tc in range(1, T + 1):
    N, K = map(int, input().split())
    volume = []
    cost = []
    for _ in range(N):
        v, c = map(int, input().split())
        volume.append(v)
        cost.append(c)
    print(f'#{tc} {knapsack(volume, cost)}')