from collections import deque

def solution(n, edge):
    visited = [-1] * (n+1)
    edge.sort()
    graph = [[] for _ in range(n+1)]

    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])

    que = deque()
    que.append(1)
    visited[1] = 0
    while que:
        n = que.popleft()
        for m in graph[n]:
            if visited[m] == -1:
                que.append(m)
                visited[m] = visited[n] + 1

    answer = visited.count(max(visited))
    return answer
