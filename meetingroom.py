N = int(input())
A = []
for i in range(N):
    start, end = map(int, input().split())
    A.append((start, end))
A = sorted(A, key = lambda x : (x[1], x[0]))

count = 1
end1 = A[0][1]
for i in range(N-1):
    if end1 <= A[i+1][0]:
        count += 1
        end1 = A[i+1][1]
print(count)
