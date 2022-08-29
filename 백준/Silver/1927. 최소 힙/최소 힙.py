import sys
import heapq
input = sys.stdin.readline
N = int(input())
q = []
for _ in range(N):
    cmp = int(input())
    if cmp == 0:
        if q:
            print(heapq.heappop(q))
        else:
            print(0)
    else:
        heapq.heappush(q, cmp)
            
        