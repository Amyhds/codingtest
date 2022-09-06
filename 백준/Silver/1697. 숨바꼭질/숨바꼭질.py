from collections import deque
import sys
input = sys.stdin.readline

def BFS(start, goal):
    Q = deque([start])
    while Q:
        v = Q.popleft()
        if v == goal:
            return dist[v]
        v_list = [v-1, v+1, v*2]
        for i in v_list:
            if 0 <= i <= 100000 and dist[i] == 0:
                dist[i] = dist[v] + 1
                Q.append(i)
        

N, K = map(int, input().split())
dist = [0] * 100001
print(BFS(N, K))

