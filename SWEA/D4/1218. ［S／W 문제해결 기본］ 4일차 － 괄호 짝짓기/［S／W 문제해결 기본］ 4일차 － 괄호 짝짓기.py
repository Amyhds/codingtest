for tc in range(1, 11):
    N = int(input())
    P = list(input())
    left = ['(', '[', '{', '<']
    right = [')', ']', '}', '>']
    stack = []
    for i in range(N):
        if P[i] in left:
            stack.append(P[i])
        elif P[i] in right:
            if left.index(stack[-1]) == right.index(P[i]):
                stack.pop()
            else:
                break
    if not stack:
        print(f'#{tc} 1')
    else:
        print(f'#{tc} 0')