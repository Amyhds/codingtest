import sys
input = sys.stdin.readline
N = int(input())
Nums = [0] * 10001    
for _ in range(N):
    k = int(input())
    Nums[k] += 1
for i in range(10001):
    if Nums[i] != 0:
        for j in range(Nums[i]):
            print(i)