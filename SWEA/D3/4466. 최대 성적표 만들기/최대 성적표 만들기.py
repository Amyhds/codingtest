T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())
    score = list(map(int, input().split()))
    score.sort(reverse = True)
    res = 0
    for i in range(K):
        res += score[i]
    print(f'#{tc} {res}')
    