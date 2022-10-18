T = int(input())
for tc in range(1, T+1):
    N = int(input())
    res = ''
    for _ in range(N):
        C, K = input().split()
        for _ in range(int(K)):
            res += C
    print(f'#{tc}')
    for i in range(len(res)):
        if i != 0 and i % 10 == 0:
            print()
            print(res[i], end='')
        else:
            print(res[i], end='')
    print()       