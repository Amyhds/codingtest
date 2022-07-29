def binary_search(A, b):
    start = 0
    end = len(A) - 1
    while start <= end:
        mid = (start+end)//2
        if b == A[mid]:
            return 1
        elif b > A[mid]:
            start = mid + 1
        else:
            end = mid - 1
    return 0
N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))
A.sort()
for b in B:
    print(binary_search(A, b))