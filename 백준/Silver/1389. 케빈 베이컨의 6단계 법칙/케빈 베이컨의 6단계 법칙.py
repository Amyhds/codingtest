from collections import deque
def BFS(graph, start):
    cnt = [0] * (N+1)
    Q = deque([start])
    visited[start] = True
    while Q:
        v = Q.popleft()
        for i in graph[v]:
            if not visited[i]:
                cnt[i] = cnt[v] + 1
                Q.append(i)
                visited[i] = True
    return sum(cnt)
N, M = map(int, input().split())
F = [[] for _ in range(N+1)]
res = []
for _ in range(M):
    a, b = map(int, input().split())
    F[a].append(b)
    F[b].append(a)
for i in range(1, N+1):
    visited = [False] * (N+1)
    res.append(BFS(F, i))
print(res.index(min(res)) + 1)