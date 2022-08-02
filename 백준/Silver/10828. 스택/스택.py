import sys
input = sys.stdin.readline
N = int(input())
stk = []
for _ in range(N):
    cmd = input().split()
    if cmd[0] == 'push':
        stk.append(cmd[1])
    elif cmd[0] == 'pop':
        if stk:
            print(stk.pop())
        else:
            print(-1)
    elif cmd[0] == 'size':
        print(len(stk))
    elif cmd[0] == 'empty':   
        if stk:
            print(0)
        else:
            print(1)
    elif cmd[0] == 'top':
        if stk:
            print(stk[-1])
        else:
            print(-1)