def solution(participant, completion):
    answer = ''
    d = {}
    for p in participant:
        d[p] = d.get(p,0) + 1
    for c in completion:
        d[c] -= 1
    for key, value in d.items():
        if value > 0:
            answer = key
    return answer