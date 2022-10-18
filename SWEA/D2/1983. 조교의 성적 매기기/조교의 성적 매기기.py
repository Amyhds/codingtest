T = int(input())
grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']
for tc in range(1, T+1):
    N, K = map(int, input().split())
    scores = [list(map(int, input().split())) for _ in range(N)]
    credit = []
    for i in range(N):
        credit.append(scores[i][0] * 0.35 + scores[i][1] * 0.45 + scores[i][2] * 0.2)
    k_credit = credit[K-1]
    credit.sort(reverse=True)
    k_idx = credit.index(k_credit)
    res = grade[k_idx//(N//10)]
    print(f'#{tc} {res}')
        