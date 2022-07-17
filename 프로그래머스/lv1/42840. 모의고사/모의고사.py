def solution(answers):
    count = [0 for _ in range(3)]
    A = [1, 2, 3, 4, 5]
    B = [2, 1, 2, 3, 2, 4, 2, 5]
    C = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    #A
    for i in range(len(answers)):
        if answers[i] == A[i % 5]:
            count[0] += 1
    #B
        if answers[i] == B[i % 8]:
            count[1] += 1
    #C
        if answers[i] == C[i % 10]:
            count[2] += 1
    m = max(count)
    answer = [i+1 for i, v in enumerate(count) if v==m]
    return answer