import sys
input = sys.stdin.readline

N = int(input())
XY = []
for _ in range(N):
    z = list(map(int, input().split()))
    XY.append(z)
XY.sort(key = lambda x:(x[1], x[0]))
for i in range(N):
    print(XY[i][0], XY[i][1])