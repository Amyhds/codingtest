while True:
    S = input()
    if S == '.':
        break
    stack = []
    for w in S:
        if w == '(' or w == '[':
            stack.append(w)
        elif w == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                print('no')
                break
        elif w == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                print('no')
                break
    else:
        if not stack:
            print('yes')
        else:
            print('no')