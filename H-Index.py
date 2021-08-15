# 이상적인 답 근데 어떻게???
# 문제에서는 [h번 이상 인용이 몇편인가? -> 그 편수가 h이상인가?]
# 의 순서로 사고하도록 적어두었습니다만
# 위의 경우는 [지금 몇 편이 남았는가? -> 모든 인용횟수가 이 값보다 큰가?(가장 작은 값이 이 값보다 큰가?)]
# 로 생각의 순서를 바꾼 것이라고 할 수 있겠습니다.
def solution(citations):
    citations.sort()
    for i in range(len(citations)):
        if citations[i] >= (len(citations) - i):
            return len(citations) - i
    return 0