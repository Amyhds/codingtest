import sys
input = sys.stdin.readline
N, M, B = map(int, input().split())
land = [list(map(int, input().split())) for _ in range(N)]
T = 100000000000000
Min = min(map(min, land))
Max = max(map(max, land))
for h in range(Min, Max+1):
    p_cnt = 0
    m_cnt = 0
    for i in range(N):
        for j in range(M):
            dif = land[i][j] - h
            if dif > 0:
                m_cnt += dif
            elif dif < 0:
                p_cnt -= dif
    if m_cnt + B >= p_cnt:
        temp = m_cnt * 2 + p_cnt
        if T >= temp:
            T = temp
            H = h
print(T, H)