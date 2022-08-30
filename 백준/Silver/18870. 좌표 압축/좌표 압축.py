import sys
input = sys.stdin.readline
N = int(input())
X = list(map(int, input().split()))
dic = {}
X_sort = sorted(set(X))
for i in range(len(X_sort)):
    dic[X_sort[i]] = i
for i in X:
    print(dic[i], end = ' ')

