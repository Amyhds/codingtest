from collections import deque

def BFS(v):
    q = deque()
    q.append(start)
    visited[start] = 1
    while q:
        v = q.popleft()
        if arr[v]:
            for i in arr[v]:
                if not visited[i]:
                    q.append(i)
                    visited[i] = visited[v] + 1
        
for tc in range(1, 11):
    L, start = map(int, input().split())
    cmd = list(map(int, input().split()))
    arr = [[] for _ in range(101)]
    visited = [0] * 101
    for i in range(0, L-1, 2):
        arr[cmd[i]].append(cmd[i+1])
    BFS(start)
    k = max(visited)
    res = 0
    for i in range(101):
        if visited[i] == k and res < i:
            res = i
    print(f'#{tc} {res}')
    