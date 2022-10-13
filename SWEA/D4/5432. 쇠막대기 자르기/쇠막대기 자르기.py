T = int(input())
for tc in range(1, T+1):
    sticks = list(input())
    stk= []
    cnt = 0
    for i in range(len(sticks)):
        if sticks[i] == "(":
            stk.append("(")
        elif sticks[i] == ")":
            if sticks[i-1] == "(":
                stk.pop()
                cnt += len(stk)
            else:
                stk.pop()
                cnt += 1
    print(f'#{tc} {cnt}')