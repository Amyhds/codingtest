#시간초과! 답 찾아봄  
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    score = list(map(int, input().split()))
    case = [0] * (sum(score)+1)
    case[0] = 1
    res = [0]
    for s in score:
        temp = list(res)
        for t in temp:
            if not case[s+t]:
                case[s+t] = 1
                res.append(s+t)
    print(f'#{tc} {len(res)}')
    