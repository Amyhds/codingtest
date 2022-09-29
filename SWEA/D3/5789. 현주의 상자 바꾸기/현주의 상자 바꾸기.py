T = int(input())
for test_case in range(1, T+1):
    N, Q = map(int, input().split())
    box = [0 for _ in range(N)]
    for i in range(Q):
        L, R = map(int, input().split())
        L -= 1
        R -= 1
        for j in range(L, R+1):
            box[j] = i+1
    print(f'#{test_case}', end=' ')
    for b in box:
        print(b, end=' ')
    print()
        