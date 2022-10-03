T = int(input())
for tc in range(1, T+1):
    n, m = map(int, input().split())
    t = n - m
    u = 2*m - n
    print(f'#{tc} {u} {t}')