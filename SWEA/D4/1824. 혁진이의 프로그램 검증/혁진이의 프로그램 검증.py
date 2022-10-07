#답보고 함
from collections import deque

T = int(input())
for tc in range(1, T+1):
    R, C = map(int, input().split())
    cmd = [list(input()) for _ in range(R)]
    visited = [[set() for _ in range(C)] for _ in range(R)]
    res = "NO"
    q = deque([(0, 0, 0, 1, 0)])
    while q:
        x, y, dx, dy, mem = q.popleft()
        if cmd[x][y] == "@":
            res = "YES"
            break
        elif cmd[x][y].isdigit():
            mem = int(cmd[x][y])
        elif cmd[x][y] == "<":
            dx, dy = 0, -1
        elif cmd[x][y] == ">":
            dx, dy = 0, 1
        elif cmd[x][y] == "^":
            dx, dy = -1, 0
        elif cmd[x][y] == "v":
            dx, dy = 1, 0
        elif cmd[x][y] == "_":
            if mem == 0:
                dx, dy = 0, 1
            else:
                dx, dy = 0, -1
        elif cmd[x][y] == "|":
            if mem == 0:
                dx, dy = 1, 0
            else:
                dx, dy = -1, 0
        elif cmd[x][y] == ".":
            pass
        elif cmd[x][y] == "+":
            if mem != 15:
                mem += 1
            else:
                mem = 0
        elif cmd[x][y] == "-":
            if mem != 0:
                mem -= 1
            else:
                mem = 15
        Dir = [(dx, dy)]
        if cmd[x][y] == "?":
            Dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        for dx, dy in Dir:
            if (dx, dy, mem) not in visited[x][y]:
                nx = (x + dx) % R
                ny = (y + dy) % C
                q.append((nx, ny, dx, dy, mem))
                visited[x][y].add((dx, dy, mem))

    print(f'#{tc} {res}')