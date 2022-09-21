T = int(input())
for test_case in range(1, T + 1):
    H, W = map(int, input().split())
    Map = []
    for _ in range(H):
        Map.append(list(input()))
    N = int(input())
    cmd = list(input())
    x = 0
    y = 0
    Dir = ''
    # 전차위치와 방향
    for i in range(H):
        for j in range(W):
            if Map[i][j] in ['<', '>', '^', 'v']:
                x = i
                y = j
                Dir = Map[i][j]
                break
    # 명령어
    for i in range(N):
        if cmd[i] == 'S':
            if Dir == '<':
                for j in range(y - 1, -1, -1):
                    if Map[x][j] == '#':
                        break
                    elif Map[x][j] == '*':
                        Map[x][j] = '.'
                        break
            elif Dir == '>':
                for j in range(y + 1, W):
                    if Map[x][j] == '#':
                        break
                    elif Map[x][j] == '*':
                        Map[x][j] = '.'
                        break
            elif Dir == '^':
                for j in range(x - 1, -1, -1):
                    if Map[j][y] == '#':
                        break
                    elif Map[j][y] == '*':
                        Map[j][y] = '.'
                        break
            elif Dir == 'v':
                for j in range(x + 1, H):
                    if Map[j][y] == '#':
                        break
                    elif Map[j][y] == '*':
                        Map[j][y] = '.'
                        break
        elif cmd[i] == 'U':
            Dir = '^'
            nx = x - 1
            if 0 <= nx < H and Map[x - 1][y] == '.':
                Map[x][y] = '.'
                x = nx
            Map[x][y] = '^'
        elif cmd[i] == 'D':
            Dir = 'v'
            nx = x + 1
            if 0 <= nx < H and Map[x + 1][y] == '.':
                Map[x][y] = '.'
                x = nx
            Map[x][y] = 'v'
        elif cmd[i] == 'L':
            Dir = '<'
            ny = y - 1
            if 0 <= ny < W and Map[x][y - 1] == '.':
                Map[x][y] = '.'
                y = ny
            Map[x][y] = '<'
        elif cmd[i] == 'R':
            Dir = '>'
            ny = y + 1
            if 0 <= ny < W and Map[x][y + 1] == '.':
                Map[x][y] = '.'
                y = ny
            Map[x][y] = '>'
    print('#' + str(test_case), end=' ')
    for i in range(H):
        print(''.join(Map[i]))