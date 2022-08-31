import sys
input = sys.stdin.readline
N, M = map(int, input().split())
tree = list(map(int, input().split()))
short = 0
long = max(tree)
while short <= long:
    mid = (short + long) // 2
    Sum = 0
    for t in tree:
        if t > mid:
            Sum += (t - mid)
    if Sum >= M:
        short = mid + 1
    else:
        long = mid - 1
print(long)