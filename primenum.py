from itertools import permutations

def solution(numbers):
    newlist = []
    for i in range(1, len(numbers) + 1):
        # i개의 원소로 순열만들기 (1~numbers의 길이)
        for j in list(permutations(numbers, i)):
            newlist.append(int(''.join(j)))
    # 중복제거
    newlist = list(set(newlist))
    answer = len(newlist)
    for i in newlist:
        if i <= 1:
            answer -= 1
            continue
        for j in range(2, int(i ** 0.5)+ 1):
            if i % j == 0:
                answer -= 1
                break
    return answer

numbers = '17'
solution(numbers)