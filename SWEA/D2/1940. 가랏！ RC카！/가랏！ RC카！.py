T = int(input())
for tc in range(1, T+1):
    N = int(input())
    m = 0
    v = 0
    for _ in range(N):
        cmd = input().split()
        if len(cmd) > 1:
            if int(cmd[0]) == 1:
                v += int(cmd[1])
                m += v
            else:
                v -= int(cmd[1])
                if v < 0:
                    v = 0
                m += v
        else:
            m += v
    print(f'#{tc} {m}')