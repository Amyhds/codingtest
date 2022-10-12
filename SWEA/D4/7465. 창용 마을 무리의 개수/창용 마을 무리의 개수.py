def DFS(start):
    global res
    stack = [start]
    while(stack):
        node = stack.pop() 
        if visited[node] == 0:
            visited[node] = 1
            if link[node]:
                stack.extend(link[node])
            else:
                break
    res += 1

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    link = [[] for _ in range(N+1)]
    visited = [0] * (N+1)
    res = 0
    for _ in range(M):
        a, b = map(int, input().split())
        link[a].append(b)
        link[b].append(a)
    for i in range(1, N+1):
        if visited[i] == 0:
            DFS(i)     
    print(f'#{tc} {res}')