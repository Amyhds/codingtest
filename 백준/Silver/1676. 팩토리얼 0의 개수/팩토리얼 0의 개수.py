def fac(n):
    if n == 0 or n == 1:
        return 1
    else:
        return fac(n-1) * n
    
N = int(input())
res = str(fac(N))
count = 0
for i in range(len(res)-1, -1, -1):
    if res[i] == '0':
        count += 1
    else:
        break
print(count)    