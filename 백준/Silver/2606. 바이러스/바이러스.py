from collections import deque

def BFS(graph, start, visited):
    que = deque([start])
    visited[start] = 1
    while que:
        v = que.popleft()
        for i in graph[v]:
            if visited[i] == 0:
                visited[i] = 1
                que.append(i)
    
N = int(input())
pair = int(input())
graph = [[] for _ in range(N+1)]
for _ in range(pair):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
visited = [0] * (N+1)
BFS(graph, 1, visited)
print(sum(visited)-1)