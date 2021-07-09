zero = [1, 0]
one = [0, 1]

T = int(input())

for i in range(2, 40):
    zero.append(zero[i-1] + zero[i-2])
    one.append(one[i-1] + one[i-2])

for _ in range(T):
    N = int(input())
    print(zero[N], one[N])