def solution(arr1, arr2):
    l1 = len(arr1)
    l2 = len(arr1[0])
    for i in range(l1):
        for j in range(l2):
             arr1[i][j] += arr2[i][j]
    return arr1