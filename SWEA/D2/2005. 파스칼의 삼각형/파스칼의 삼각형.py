T = int(input())
for tc in range(1, T+1):
    N = int(input())
    pascal = [[] for _ in range(N)]
    for i in range(N):
        if i == 0:
            pascal[i].append(1)
        elif i == 1:
            pascal[i].append(1)
            pascal[i].append(1)
        else:
            pascal[i].append(1)
            for j in range(i-1):
                pascal[i].append(pascal[i-1][j]+pascal[i-1][j+1])
            pascal[i].append(1)
    print(f'#{tc}')
    for i in range(N):
        print(*pascal[i])
            
            