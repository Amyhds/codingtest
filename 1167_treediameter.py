import sys
from collections import deque
input1 = sys.stdin.readline

V = int(input1())
tree = [[] for _ in range(V+1)]

for _ in range(V):
    edge = list(map(int, input1().split()))
    for e in range(1, len(edge)-1, 2):
        tree[edge[0]].append((edge[e], edge[e+1]))

#임의의 점을 잡고 그 점으로부터 최대거리를 가진 곳의 인덱스에서 
#다시 최대 거리를 구하면 그것이 지름이 된다
#https://velog.io/@coding_egg/%EB%B0%B1%EC%A4%80-1991%EB%B2%88-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EC%A7%80%EB%A6%84-python-%ED%8C%8C%EC%9D%B4%EC%8D%AC

def BFS(start):
    visited = [-1] * (V+1)
    que = deque()
    que.append(start)
    visited[start] = 0
    _max = [0, 0]
    while que:
        n = que.popleft()
        for e, l in tree[n]:
            if visited[e] == -1:
                visited[e] = visited[n] + l
                que.append(e)
                if _max[0] < visited[e]:
                    _max = visited[e], e

    return _max

l, e = BFS(1)
l, e = BFS(e)
print(l)