import sys
input = sys.stdin.readline
N, M = map(int, input().split())
Book = {}
for i in range(1, N+1):
    name = input().rstrip()
    Book[i] = name
    Book[name] = i
for j in range(M):
    q = input().rstrip()
    if q.isdigit():
        print(Book[int(q)])
    else:
        print(Book[q])