def selfnum(num):
    for n in str(num):
        num += int(n)
    return num

N = int(input())
for i in range(1, N+1):
    s = selfnum(i)
    if s == N:
        print(i)
        break
else:
    print(0)
        
    