import sys
input = sys.stdin.readline
M = int(input())
s = set()
for _ in range(M):
    cmd = input().split()
    if len(cmd) == 1:
        if cmd[0] == 'all':
            s = set([i for i in range(1, 21)])
        else:
            s = set()
    else: 
        command, num = cmd[0], int(cmd[1])
        if command == 'add':
            s.add(num)
        elif command == 'remove':
            s.discard(num)
        elif command == 'check':
            if num in s:
                print(1)
            else:
                print(0)
        elif command == 'toggle':
            if num in s:
                s.discard(num)
            else:
                s.add(num)