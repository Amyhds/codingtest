from collections import deque
def taller(i):
    cnt = 0
    visited = [0] * (N+1)
    q = deque()
    q.append(i)
    visited[i] = 1
    while q:
        v = q.popleft()
        for j in range(1, N+1):
            if compare[v][j] == 1 and not visited[j]:
                visited[j] = 1
                q.append(j)
                cnt += 1
    return cnt

def shorter(i):
    cnt = 0
    visited = [0] * (N+1)
    q = deque()
    q.append(i)
    visited[i] = 1
    while q:
        v = q.popleft()
        for j in range(1, N+1):
            if compare[j][v] == 1 and not visited[j]:
                visited[j] = 1
                q.append(j)
                cnt += 1
    return cnt

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    M = int(input())
    compare = [[0]*(N+1) for _ in range(N+1)]
    res = 0
    for _ in range(M):
        a, b = map(int, input().split())
        compare[a][b] = 1
    for i in range(1, N+1):
        cnt = taller(i) + shorter(i)
        if cnt == N - 1:
            res += 1
    print(f'#{tc} {res}')