import sys
input = sys.stdin.readline
N, M = map(int, input().split())
nums = list(map(int, input().split()))
pre = [0]
temp = 0
for n in nums:
    temp += n
    pre.append(temp)
for _ in range(M):
    i, j = map(int, input().split())
    print(pre[j] - pre[i-1])