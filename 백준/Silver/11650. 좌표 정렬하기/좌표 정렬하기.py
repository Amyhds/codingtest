import sys
input = sys.stdin.readline

N = int(input())
dots = []
for _ in range(N):
    d = list(map(int, input().split()))
    dots.append(d)
dots.sort(key=lambda x:(x[0], x[1]))
for i in range(N):
    print(dots[i][0], dots[i][1])