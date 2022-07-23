import sys
input = sys.stdin.readline

N = int(input())
l = []
for _ in range(N):
    num = int(input())
    l.append(num)
l.sort()
for num in l:
    print(num)