def solution(numbers):
    numbers.sort()
    new_num = numbers
    for i in range(len(numbers)):
        if numbers[i] >= 10:
            new_num[i] = numbers[i] // (10 ** (len(numbers[i]) - 1))
            num = num % (10 ** (len(num) - 1))

    answer = ''
    return answer