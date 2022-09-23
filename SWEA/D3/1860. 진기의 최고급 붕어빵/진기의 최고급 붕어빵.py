#시간초과나서 아이디어 얻고 풂
T = int(input())
for test_case in range(1, T+1):
    N, M, K = map(int, input().split())
    arrive = list(map(int, input().split()))
    arrive.sort()
    res = 'Possible'
    for i in range(N):
        total = (arrive[i] // M) * K - (i+1)
        if total < 0:
            res = 'Impossible'
            break
    print(f'#{test_case} {res}')