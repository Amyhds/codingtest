T = int(input())
for tc in range(1, T+1):
    N, D = map(int, input().split())
    water = D*2 + 1
    if N % water == 0:
        print(f'#{tc} {N//water}')
    else:
        print(f'#{tc} {N//water+1}')