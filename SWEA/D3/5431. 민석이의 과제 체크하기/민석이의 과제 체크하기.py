T = int(input())
for test_case in range(1, T+1):
    N, K = map(int, input().split())
    student = {i for i in range(1, N+1)}
    submit = set(list(map(int, input().split())))
    res = student - submit
    print(f'#{test_case}', end = ' ')
    for r in res:
        print(r, end = ' ')
    print()