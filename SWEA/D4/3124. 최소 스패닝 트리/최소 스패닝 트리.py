def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b
        
T = int(input())
for tc in range(1, T+1):
    V, E = map(int, input().split())
    edge = [list(map(int, input().split())) for _ in range(E)]
    edge.sort(key = lambda x: x[2])
    parent = [0] * (V+1)
    res = 0
    for i in range(V):
        parent[i] = i
    for e in edge:
        a, b, cost = e
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            res += cost
    print(f'#{tc} {res}')