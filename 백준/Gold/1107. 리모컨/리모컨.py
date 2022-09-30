#답보고 했다..!브루트포스는 말그대로 모든 경우의 수 다 따져봄
import sys
input = sys.stdin.readline
N = int(input())
M = int(input())
if M > 0:
    broken = list(input().split())
else:
    broken = []
res = abs(100 - N)
for num in range(1000001):
    for k in str(num):
        if k in broken:
            break
    else:
        res = min(res, len(str(num)) + abs(num - N))
print(res)