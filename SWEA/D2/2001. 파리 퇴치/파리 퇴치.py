T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]
    fly = []
    for i in range(N-M+1):
        for j in range(N-M+1):
            cnt = 0
            for x in range(M):
                for y in range(M):
                    cnt += arr[i+x][j+y]
            fly.append(cnt)
    print(f'#{tc} {max(fly)}')