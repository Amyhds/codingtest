def solution(array, commands):
    answer = []
    for i, j, k in commands:
        array1 = array[i-1:j]
        array1.sort()
        answer.append(array1[k-1])
    return answer