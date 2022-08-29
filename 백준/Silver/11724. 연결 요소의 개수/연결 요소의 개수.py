from collections import deque
import sys
input = sys.stdin.readline

def bfs(start, visited):
    Q = deque([start])
    visited[start] = True
    while Q:
        v = Q.popleft()
        for i in graph[v]:
            if not visited[i]:
                Q.append(i)
                visited[i] = True
        
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
count = 0
for i in range(1, N+1):
    if not visited[i]:
        bfs(i, visited)
        count += 1
print(count)
