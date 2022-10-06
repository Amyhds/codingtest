# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    X = list(map(int, input().split()))
    Y = list(map(int, input().split()))
    E = float(input())
    parent = [0] * N
    edge = []
    res = 0
    for i in range(N):
        parent[i] = i
    for i in range(N):
        for j in range(i + 1, N):
            L = float(((X[i] - X[j]) ** 2 + (Y[i] - Y[j]) ** 2) ** 0.5)
            cost = E * (L**2)
            edge.append((cost, i, j))
    edge.sort()
    for e in edge:
        cost, a, b = e
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            res += cost
    print(f'#{tc} {round(res)}')