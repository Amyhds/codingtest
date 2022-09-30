import sys
from collections import deque
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    p = input()
    n = int(input())
    R = 0
    lst = deque(list(input().rstrip()[1:-1].split(',')))
    if n == 0:
        lst = deque()
    for i in range(len(p)):
        if p[i] == 'R':
            R += 1
        elif p[i] == 'D':
            if len(lst) == 0:
                print('error')
                break
            else:
                if R % 2 == 0:
                    lst.popleft()
                else:
                    lst.pop()
    else:
        if R % 2 == 1:
            lst.reverse()
            print('[' + ','.join(lst) + ']')
        else:
            print('[' + ','.join(lst) + ']')