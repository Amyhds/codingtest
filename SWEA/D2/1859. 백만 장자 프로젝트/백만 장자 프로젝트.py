T = int(input())
for tc in range(1, T+1):
    N = int(input())
    price = list(map(int, input().split()))
    m = 0
    total = 0
    for i in range(N-1, -1, -1):
        if m < price[i]:
            m = price[i]
        else:
            total += m
            total -= price[i]
    print(f'#{tc} {total}')
        
        