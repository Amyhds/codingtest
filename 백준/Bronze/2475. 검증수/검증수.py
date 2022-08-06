A = list(map(int, input().split()))
for i in range(5):
    A[i] = A[i]*A[i]
s = sum(A)
print(s%10)
    