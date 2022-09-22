import sys
input = sys.stdin.readline
N = int(input())
M = int(input())
S = input()
count = 0
pattern = 0
i = 0

while i < M - 1:
    if S[i: i+3] == "IOI":
        i += 2
        pattern += 1
        if pattern == N:
            count += 1
            pattern -= 1
    else:
        i += 1
        pattern = 0

print(count)