T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    A = list(map(int, input().split()))
    dp = [1] * N
    for i in range(1, N):
        for j in range(i):
            if A[i] > A[j]:
                dp[i] = max(dp[i], dp[j]+1)
    print(f'#{test_case} {max(dp)}')