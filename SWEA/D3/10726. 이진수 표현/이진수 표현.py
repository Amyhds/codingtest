T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    res = ''
    for _ in range(N):
        if M % 2 == 0:
            print(f'#{tc} OFF')
            break
        else:
            M = M // 2
    else:
        print(f'#{tc} ON')