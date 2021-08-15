import sys
sys.setrecursionlimit(10**9)

def DFS(tree, start, parent):
    stack = [start]
    while stack:
        n = stack.pop()
        for i in tree[n]:
            if parent[i]:
                continue
            parent[i] = n
            stack.append(i)
    return parent

N = int(input())
tree = [[] for _ in range(N + 1)]
parent = [0 for _ in range(N + 1)]

for _ in range(N-1):
    a, b = map(int, sys.stdin.readline().split())
    tree[a].append(b)
    tree[b].append(a)

DFS(tree, 1, parent)

for p in parent[2:]:
    print(p)

''' # 시간초과
def DFS(tree, start, parent):
    for i in tree[start]:
        if parent[i] == 0:
            parent[i] = start
            DFS(tree, i, parent)

N = int(input())
tree = [[] for _ in range(N + 1)]
parent = [0 for _ in range(N + 1)]

for i in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

DFS(tree, 1, parent)

for i in range(2, N+1):
    print(parent[i])
'''


''' # 좀더 직관적.. 근데 시간초과
def DFS(graph, start, parent):
    stack = [start]
    while stack:
        n = stack.pop()
        for i in graph[n]:
            parent[i].append(n)
            stack.append(i)
            graph[i].remove(n)
    return parent

N = int(input())
graph = [[] for _ in range(N + 1)]
parent = [[] for _ in range(N + 1)]

for i in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

DFS(graph, 1, parent)

for i in range(2, N+1):
    print(parent[i][0])
'''