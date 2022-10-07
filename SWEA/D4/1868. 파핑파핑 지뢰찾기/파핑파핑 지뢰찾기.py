# 답 참고..
from collections import deque

def findMine(near):
    q = deque(near)
    while q:
        x, y = q.popleft()
        arr[x][y] = 'o'
        near2 = []
        for i in range(8):
            nx = x + d[i][0]
            ny = y + d[i][1]
            if 0 <= nx < N and 0 <= ny < N:
                if arr[nx][ny] == '*':
                    break
                elif arr[nx][ny] == '.':
                    near2.append((nx, ny))
        else:
            findMine(near2)


def findZero(x, y):
    global cnt
    near = []
    for i in range(8):
        nx = x + d[i][0]
        ny = y + d[i][1]
        if 0 <= nx < N and 0 <= ny < N:
            if arr[nx][ny] == '*':
                break
            elif arr[nx][ny] == '.':
                near.append((nx, ny))
    else:
        if near:
            arr[x][y] = 'o'
            cnt += 1
            findMine(near)
def rest():
    global cnt
    # 폭탄으로 막혀잇는 곳???
    for i in range(N):
        for j in range(N):
            if arr[i][j] == ".":
                cnt += 1

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    arr = [list(input()) for _ in range(N)]
    d = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (-1, -1), (-1, 1), (1, -1)]
    cnt = 0
    for i in range(N):
        for j in range(N):
            if arr[i][j] == ".":
                findZero(i, j)
    rest()
    print(f'#{tc} {cnt}')