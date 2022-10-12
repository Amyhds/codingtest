def cal(x):
    if type(nodes[x][0]) == int:
        return nodes[x][0]
    else:
        left = cal(nodes[x][1])
        right = cal(nodes[x][2])

        if nodes[x][0] == '+':
            return left + right
        elif nodes[x][0] == '-':
            return left - right
        elif nodes[x][0] == '*':
            return left * right
        elif nodes[x][0] == '/':
            return left / right

for tc in range(1, 11):
    N = int(input())
    nodes = [[] for _ in range(N+1)]
    res = 0
    for _ in range(N):
        cmd = input().split()
        if len(cmd) > 3:
            nodes[int(cmd[0])].append(cmd[1])
            nodes[int(cmd[0])].append(int(cmd[2]))
            nodes[int(cmd[0])].append(int(cmd[3]))
        else:
            nodes[int(cmd[0])].append(int(cmd[1]))
    res = int(cal(1))
    print(f'#{tc} {res}')
