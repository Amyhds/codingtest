#아 너무 어렵다 무슨소리지
#https://pgh268400.tistory.com/464
import sys
input = sys.stdin.readline
n = int(input())
d = [0] * (n+1)
d[1] = 1
for i in range(2, n+1):
    k = 1
    count = 4
    while (k**2) <= i:
        temp = d[i - (k**2)]
        count = min(count, temp)
        k += 1
    d[i] = count + 1
print(d[n])
'''
n = int(input())
dp = [4] * (n+1)
dp[1] = 1

for i in range(2, n+1):
    if int(i ** 0.5) ** 2 == i:
        dp[i] = 1
    else:
        j = 1
        while j**2 < i:
            dp[i] = min(dp[j**2] + dp[i-j**2], dp[i])
            j += 1
print(dp[n])
'''         