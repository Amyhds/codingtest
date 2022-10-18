T = int(input())
for tc in range(1, T+1):
    N = int(input())
    num = [2, 3, 5, 7, 11]
    res = [0] * 5
    for i in range(5):
        while N % num[i] == 0:
            res[i] += 1
            N = N // num[i]
    print(f'#{tc}', end = ' ')
    print(*res)