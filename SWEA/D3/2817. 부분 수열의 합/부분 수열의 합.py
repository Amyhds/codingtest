def dfs(index, total):
    global result
    if total == K:
        result += 1
        return
    if index == N:
        return
    dfs(index+1, total+A[index])
    dfs(index+1, total)

T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())
    A = list(map(int, input().split()))
    result = 0
    dfs(0, 0)
    print(f"#{tc} {result}")