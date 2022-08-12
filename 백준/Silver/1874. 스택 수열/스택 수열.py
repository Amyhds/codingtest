import sys
input = sys.stdin.readline
n = int(input())
seq = []
res = []
start = 1
flag = True
for _ in range(n):
    num = int(input())
    while start <= num:
        seq.append(start)
        res.append('+')
        start += 1
    if seq[-1] == num:
        seq.pop()
        res.append('-')
    else:
        flag = False
if flag == False:
    print('NO')
else:
    for i in res:
        print(i)