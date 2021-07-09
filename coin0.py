N, K = map(int, input().split())

A = []
for i in range(N):
    A.append(int(input()))

count = 0
A.reverse()

for i in range(N):
    if K >= A[i]:
        count = count + K//A[i] #몫을 count에 저장
        K = K % A[i] #나머지가 K가 됨

print(count)

'''
import sys
N, K = map(int, sys.stdin.readline().split())

A = [0]
for i in range(1, N + 1):
    A.append(int(sys.stdin.readline()))

result = 0
current = 0
while(current < K):
    if max(A) + current > K:
        A.pop()
    else:
        current = current + max(A)
        result += 1

print(result)
'''