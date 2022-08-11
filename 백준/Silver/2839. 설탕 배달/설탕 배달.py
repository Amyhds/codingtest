'''N = int(input())
d = [5001] * (N+1)
d[0] = 0
money = [3, 5]

for i in range(2):
    for j in range(money[i], N+1):
        if d[j - money[i]] != 5001:
            d[j] = min(d[j], d[j - money[i]] + 1)
if d[N] == 5001:
    print(-1)
else:
    print(d[N])'''
    
N = int(input())
res = 0
while N >= 0:
    if N % 5 == 0:
        res += N // 5
        print(res)
        break
    N -= 3
    res += 1
else:
    print(-1)
    