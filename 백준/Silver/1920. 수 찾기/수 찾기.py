def binary_search(A, b):
    start = 0
    end = len(A) - 1
    while start <= end:
        mid = (start+end)//2
        if b == A[mid]:
            return mid
        elif b > A[mid]:
            start = mid + 1
        else:
            end = mid - 1
    return -1
N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))
A.sort()
for b in B:
    res = binary_search(A, b)
    if res == -1:
        print(0)
    else:
        print(1)