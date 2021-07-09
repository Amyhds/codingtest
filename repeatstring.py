T = int(input())

for i in range(T):
    R, S = input().split()
    P = ''
    for k in S:
        P += k * int(R)
    print(P)