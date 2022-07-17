H, M = map(int, input().split())
M1 = M - 45

if M1 < 0:
    M1 = 60 + (M - 45)
    H -= 1
if H < 0:
    H = 24 + H
print(H, M1, sep = ' ')