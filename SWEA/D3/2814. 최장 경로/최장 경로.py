def dfs(node, cnt):
    global max_L
    if max_L < cnt:
            max_L = cnt
    for next in graph[node]:
        if not visited[next]:
            visited[next] = 1
            dfs(next, cnt + 1)
            visited[next] = 0

T = int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    graph = [[]*(N+1) for _ in range(N+1)]
    visited = [0] * (N+1)
    max_L = 0
    for i in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    for node in range(1, N+1):
        visited[node] = 1
        dfs(node, 1)
        visited[node] = 0
    print(f'#{test_case} {max_L}')