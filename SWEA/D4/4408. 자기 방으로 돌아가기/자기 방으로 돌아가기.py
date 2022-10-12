T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    room = [list(map(int, input().split())) for _ in range(N)]
    res = 1
    path = [0] * 201
    for i in range(N):
        if room[i][0] < room[i][1]:
            s = (room[i][0] + 1) // 2
            e = (room[i][1] + 1) // 2
        else:
            s = (room[i][1] + 1) // 2
            e = (room[i][0] + 1) // 2
        for j in range(s, e+1):
            path[j] += 1
            
    print(f'#{tc} {max(path)}')
