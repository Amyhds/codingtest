T = int(input())
for tc in range(1, T+1):
    N = int(input())
    for i in range(10**6+1):
        temp = i ** 3
        if temp == N:
            print(f'#{tc} {i}')
            break
    else:
        print(f'#{tc} -1')    