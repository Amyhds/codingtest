T = int(input())
for tc in range(1, T+1):
    N = int(input())
    card = list(input().split())
    first = []
    second = []
    res = []
    if N % 2 == 0:
        for i in range(0, N//2):
            first.append(card[i])
        for i in range(N//2, N):
            second.append(card[i])
        for i in range(N//2):
            res.append(first[i])
            res.append(second[i])
    else:
        for i in range(0, N//2 + 1):
            first.append(card[i])
        for i in range(N//2 + 1, N):
            second.append(card[i])
        for i in range(N//2):
            res.append(first[i])
            res.append(second[i])
        res.append(first[-1])
    print(f'#{tc}', end = ' ')
    for i in range(N):
        print(res[i], end = ' ')
    print()
        
        