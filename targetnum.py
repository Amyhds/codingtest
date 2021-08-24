# 비효율적! for문이 2개나
def solution(numbers, target):
    result = [0]
    for i in range(len(numbers)):
        temp = []
        for j in range(len(result)):
            temp.append(result[j] + numbers[i])
            temp.append(result[j] - numbers[i])
        result = temp.copy()

    return result.count(target)

# 뭐..뭐지
def solution(numbers, target):
    if not numbers and target == 0 :
        return 1
    elif not numbers:
        return 0
    else:
        return solution(numbers[1:], target-numbers[0]) + solution(numbers[1:], target+numbers[0])

# queue 이용 제일 좋은듯!
from collections import deque

def solution(numbers, target):
    cal = deque()
    cal.append(0)
    for num in numbers:
        for _ in range(len(cal)):
            prev = cal.popleft()
            cal.append(prev + num)
            cal.append(prev - num)

    return cal.count(target)