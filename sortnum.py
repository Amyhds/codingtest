N = int(input())
M = []
for i in range(N):
    M.append(int(input()))

'''
for i in range(N):        # 좀 불필요한 연산이 많은 방법
    for j in range(N):
        if M[i] < M[j]:
            M[i], M[j] = M[j], M[i] 
'''

for i in range(N):
    for j in range(N-i-1):
        if M[j] > M[j+1]:
            M[j], M[j+1] = M[j+1], M[j]

for n in M:
    print(n)

'''
N = int(input())
M = []
for i in range(N):
    M.append(int(input()))

M.sort()
for i in range(N):
    print(M[i])
'''