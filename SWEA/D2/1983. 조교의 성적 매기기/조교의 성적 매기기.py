T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    score = [list(map(int, input().split())) for _ in range(N)]
    s_list = []
    grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
    same = N // 10
    for i in range(N):
        res = score[i][0] * (35/100) + score[i][1] * (45/100) + score[i][2] * (20/100)
        s_list.append(res)
    k_std = s_list[K-1]
    s_list.sort(reverse = True)
    k_index = s_list.index(k_std)
    res = grade[k_index // same]
    print('#' + str(test_case) + ' ' + res)
    