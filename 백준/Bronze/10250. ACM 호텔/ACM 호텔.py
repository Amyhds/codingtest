T = int(input())
for _ in range(T):
    H, W, N = map(int, input().split())
    start = 1
    for _ in range(N):
        start += 100
        if start//100 == H+1:
            start = start - H*100 + 1
    print(start)
            
            