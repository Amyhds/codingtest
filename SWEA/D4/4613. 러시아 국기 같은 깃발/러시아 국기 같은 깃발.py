# 답 참고
def color(B, R):
    global cnt, Max
 
    for w in range(1, B):
        cnt += M - flag[w].count('W')
 
    for b in range(B, R):
        cnt += M - flag[b].count('B')
 
    for r in range(R, N-1):
        cnt += M - flag[r].count('R')
 
    if Max > cnt:
        Max = cnt  

T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    flag = [list(input()) for _ in range(N)]
    Max = N * M
    for i in range(1, N-1):
        for j in range(i+1, N):
            cnt = 0
            cnt += M - flag[0].count('W')
            cnt += M - flag[-1].count('R')
            color(i, j)
    print(f'#{tc} {Max}')
                  