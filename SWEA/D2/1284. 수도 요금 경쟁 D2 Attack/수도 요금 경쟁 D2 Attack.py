T = int(input())
for test_case in range(1, T + 1):
    P, Q, R, S, W = map(int, input().split())
    A = P * W
    if R > W:
        B = Q
    else:
        B = Q + (W-R)*S
    if A > B:
        print(f'#{test_case} {B}')
    else:
        print(f'#{test_case} {A}')