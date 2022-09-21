# 답 봣어유,,
def chk(idx, score, cal):
    global best_score
    # 정해진 칼로리를 넘어설 경우 리턴
    if cal > L:
        return
    # 최고 점수를 넘는다면 갱신해준다.
    if score > best_score:
        best_score = score
    # 인덱스가 N에 도달하면 리턴
    if idx == N:
        return
    # 재료를 넣지 않는 경우
    chk(idx+1, score, cal)
    # 재료를 넣는 경우
    chk(idx+1, score + food[idx][0], cal+food[idx][1])
    
T = int(input())
for test_case in range(1, T+1):
    N, L = map(int, input().split())
    food = []
    for _ in range(N):
        food.append(list(map(int, input().split())))
    best_score = 0
    chk(0, 0, 0)
    print(f'#{test_case} {best_score}')