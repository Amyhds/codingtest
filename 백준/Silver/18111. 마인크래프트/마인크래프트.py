#어렵다 답보고도 이해가 잘..
import sys
input = sys.stdin.readline
N, M, B = map(int, input().split())
land = [list(map(int, input().split())) for _ in range(N)]
res = 0
ans = 100000000000000000000
for floor in range(257):
    Max = 0
    Min = 0
    for i in range(N):
        for j in range(M):
            if land[i][j] < floor:
                Min += floor - land[i][j]
            else:
                Max += land[i][j] - floor
    blocks = Max + B
    if blocks < Min:
        continue
    time = 2 * Max + Min
    if time <= ans:
        ans = time
        res = floor
print(ans, res)

    
    

           