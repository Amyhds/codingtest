T = int(input())
for tc in range(1, T+1):
    score = list(map(int, input().split()))
    for i in range(5):
        if score[i] < 40:
            score[i] = 40
    print(f'#{tc} {int(sum(score)/5)}')
        