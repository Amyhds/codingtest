from collections import deque

def BFS(graph, V):
    visited = []
    que = deque([V])
    while que:
        n = que.popleft()
        if n not in visited:
            visited.append(n)
            que.extend(graph[n])
    return visited

C = int(input())
P = int(input())

graph = {i:[] for i in range(C + 1)}

for i in range(1, P+1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

print(len(BFS(graph, 1))-1)
