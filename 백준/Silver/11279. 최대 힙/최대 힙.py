import sys, heapq
input = sys.stdin.readline
N = int(input())
que = []
for _ in range(N):
    cmd = int(input())
    if cmd != 0:
        heapq.heappush(que, (-cmd,cmd))
    else:
        if que:
            print(heapq.heappop(que)[1])
        else:
            print(0)