T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    arr = [input() for _ in range(N)]
    d = {'0001101': 0, '0011001': 1, '0010011': 2, '0111101': 3, '0100011': 4, '0110001': 5, '0101111': 6, '0111011': 7,
         '0110111': 8, '0001011': 9}
    num = []
    code = ''
    for i in range(N):
        if sum(map(int, list(arr[i]))) == 0:
            continue
        else:
            for j in range(M - 1, -1, -1):
                if arr[i][j] == '1':
                    code = arr[i][j - 55:j + 1]
                    break
            break
    for i in range(0, 56, 7):
        num.append(d[code[i:i + 7]])
    odd = 0
    even = 0
    num_sum = 0
    for i in range(8):
        if i % 2 == 0:
            odd += num[i]
            num_sum += num[i]
        else:
            even += num[i]
            num_sum += num[i]
    res = odd * 3 + even
    if res % 10 == 0:
        print(f'#{test_case} {num_sum}')
    else:
        print(f'#{test_case} {0}')

