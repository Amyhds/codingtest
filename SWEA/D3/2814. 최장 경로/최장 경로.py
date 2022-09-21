#흐음 잘 이해가 안간다
def DFS(i, cnt):
    global max_L
    for j in range(1, N+1):
        if not visited[j] and graph[i][j]:
            visited[j] = 1 
            DFS(j, cnt + 1)
            visited[j] = 0
    else:
        if cnt > max_L:
            max_L = cnt
    
T = int(input())
for test_case in range(1, T+1):
    N, M = map(int, input().split())
    graph = [[0]*(N+1) for _ in range(N+1)]
    visited = [0] * (N+1)
    max_L = 0
    for i in range(M):
        a, b = map(int, input().split())
        graph[a][b] = 1
        graph[b][a] = 1
    for i in range(1, N+1):
        visited[i] = 1
        DFS(i, 1)
        visited[i] = 0
    print(f'#{test_case} {max_L}')