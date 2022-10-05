for _ in range(10):
    T, N = map(int, input().split())
    path = [[] for _ in range(100)]
    temp = list(map(int, input().split()))
    visited = [0] * 100
    res = 0
    for i in range(0, len(temp), 2):
        a = temp[i]
        b = temp[i+1]
        path[a].append(b)
    stack = [0]
    while stack:
        x = stack.pop()
        visited[x] = 1
        for y in path[x]:
            if y == 99:
                res = 1
                break
            if visited[y] == 0:
                stack.append(y)
    print(f'#{T} {res}')