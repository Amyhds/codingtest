#아 너무 어렵다 무슨소리지
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