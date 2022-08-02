import sys
input = sys.stdin.readline

N = int(input())
sang = list(map(int, input().split()))
M = int(input())
num_list = list(map(int, input().split()))
res = {}
for s in sang:
    if s in res:
        res[s] += 1
    else:
        res[s] = 1
        
for num in num_list:
    if num in res:
        print(res[num], end = ' ')
    else:
        print(0, end = ' ')