T = int(input())
for tc in range(1, T+1):
    side = list(map(int, input().split()))
    side.sort()
    if side[1] == side[0]:
        print(f'#{tc} {side[2]}')
    elif side[1] == side[2]:
        print(f'#{tc} {side[0]}')
    