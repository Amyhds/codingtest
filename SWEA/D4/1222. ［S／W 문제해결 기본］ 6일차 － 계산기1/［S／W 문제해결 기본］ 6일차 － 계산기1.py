for tc in range(1, 11):
    N = int(input())
    infix = input()
    stack = []
    postfix = ''
    res = 0
    for i in infix:
        if i.isdigit():
            postfix += i
        else:
            stack.append(i)
    while stack:
        postfix += stack.pop()
    for p in postfix:
        if p.isdigit():
            stack.append(p)
        else:
            second = int(stack.pop())
            first = int(stack.pop())
            if stack:
                stack.append(first + second)
            else:
                res = first + second
    print(f'#{tc} {res}')
     
        