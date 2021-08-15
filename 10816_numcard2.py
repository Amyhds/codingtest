'''
# 시간초과
def binary_search(array1, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array1[mid] == target:
            return target
        elif array1[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

N = int(input())
Narray = list(map(int, input().split()))
Narray.sort()
M = int(input())
Marray = list(map(int, input().split()))

for i in range(M):
    result = binary_search(Narray, Marray[i], 0, N-1)
    print(Narray.count(result), end = ' ')

'''
# counter 사용
from collections import Counter

N = int(input())
Narray = list(map(int, input().split()))
Narray.sort()
M = int(input())
Marray = list(map(int, input().split()))

counter = Counter(Narray)
for i in Marray:
    print(counter[i], end=' ')
