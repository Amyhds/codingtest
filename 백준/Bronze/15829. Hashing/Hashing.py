L = int(input())
S = input()
res = 0
for i in range(L):
    res += (ord(S[i]) - 96) * (31**i)
print(res%1234567891)
