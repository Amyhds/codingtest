N = int(input())
M = []
for i in range(N):
    M.append(int(input()))

for i in range(N):
    for j in range(N):
        if M[i] < M[j]:
            M[i], M[j] = M[j], M[i]

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