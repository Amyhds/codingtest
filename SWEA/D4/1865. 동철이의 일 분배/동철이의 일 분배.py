#답보고 햇다 가지치기하는 dfs?
def DFS(idx, res):
    global ans
    if res <= ans:
        return 
    if idx == N:
        ans = max(ans, res)
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = 1 
            DFS(idx+1, res * prob[idx][i] * 0.01)
            visited[i] = 0
            
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    prob = [list(map(int, input().split())) for _ in range(N)]
    visited = [0] * N
    ans = 0
    DFS(0, 1)
    print(f'#{tc}{ans*100: .6f}')