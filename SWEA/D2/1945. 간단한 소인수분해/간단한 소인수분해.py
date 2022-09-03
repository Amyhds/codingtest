T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    res = [0, 0, 0, 0, 0]
    if N % 11 == 0:
        while N % 11 == 0:
            N = N / 11
            res[4] += 1
    if N % 7 == 0:
        while N % 7 == 0:
            N = N / 7
            res[3] += 1
    if N % 5 == 0:
        while N % 5 == 0:
            N = N / 5
            res[2] += 1
    if N % 3 == 0:
        while N % 3 == 0:
            N = N / 3
            res[1] += 1
    if N % 2 == 0:
        while N % 2 == 0:
            N = N / 2
            res[0] += 1
    print('#'+str(test_case), end = ' ')
    for i in range(4):
        print(res[i], end = ' ')
    print(res[4])