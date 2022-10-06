def Postfix(infix):
    postfix = ''
    stack = []
    for i in infix:
        if i.isdigit():
            postfix += i
        else:
            if i == '*':
                while stack and stack[-1] == '*':
                    postfix += stack.pop()
                stack.append(i)
            elif i == '+':
                while stack:
                    postfix += stack.pop()
                stack.append(i)
    while stack:
        postfix += stack.pop()
    return postfix
        
def cal(postfix):
    stack = []
    for p in postfix:
        if p.isdigit():
            stack.append(int(p))
        else:
            second = stack.pop()
            first = stack.pop()
            if p == '+':
                stack.append(first + second)
            elif p == '*':
                stack.append(first * second)
    return stack.pop()
    
for tc in range(1, 11):
    N = int(input())
    infix = input()
    postfix = Postfix(infix)
    res = cal(postfix)
    print(f'#{tc} {res}')