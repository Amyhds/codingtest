from collections import deque

def DFS(graph, V):
    visited = []
    stack = [V]
    while stack:
        n = stack.pop()
        if n not in visited:
            visited.append(n)
            stack.extend(reversed(graph[n]))
    return visited

def BFS(graph, V):
    visited = []
    que = deque([V])
    while que:
        n = que.popleft()
        if n not in visited:
            visited.append(n)
            que.extend(graph[n])
    return visited

N, M, V = map(int, input().split())

graph = {i:[] for i in range(N + 1)}

for i in range(1, M+1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for k in graph:
    graph[k].sort()

print(*DFS(graph, V))
print(*BFS(graph, V))
