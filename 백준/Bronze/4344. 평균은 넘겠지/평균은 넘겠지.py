C = int(input())
for _ in range(C):
    a = list(map(int, input().split()))
    N = a[0]
    sum = 0
    for i in range(1, N+1):
        sum += a[i]
    avg = sum/N
    above = 0
    for j in range(1, N+1):
        if a[j] > avg:
            above += 1
    print("{:.3f}%".format(above/N*100))
        
