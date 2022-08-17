import sys
input = sys.stdin.readline
N, M = map(int, input().split())
trees = list(map(int, input().split()))
start = 1
end = max(trees)
while start <= end:
    mid = (start + end) // 2
    res = 0
    for i in range(N):
        if trees[i] > mid:
            res += trees[i] - mid 
    if res < M:
        end = mid - 1
    else:
        start = mid + 1
print(end)