T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    apt = [x for x in range(1, n+1)]
    for i in range(k):
        for j in range(1, n):
            apt[j] += apt[j-1]
    print(apt[-1])
        