import sys, heapq
input = sys.stdin.readline
N = int(input())
que = []
for _ in range(N):
    cmd = int(input())
    if cmd != 0:
        heapq.heappush(que, -cmd)
    else:
        if que:
            print(-1*heapq.heappop(que))
        else:
            print(0)