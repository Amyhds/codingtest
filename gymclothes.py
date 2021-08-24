def solution(n, lost, reserve):
    students = [0 for _ in range(n)]
    for l in lost:
        students[l-1] = -1
    for r in reserve:
        students[r-1] += 1

    for i in range(n-1):
        if students[i] + students[i+1] == 0 and students[i]!=0:
            students[i] = 0
            students[i+1] = 0

    answer = n - students.count(-1)
    return answer
