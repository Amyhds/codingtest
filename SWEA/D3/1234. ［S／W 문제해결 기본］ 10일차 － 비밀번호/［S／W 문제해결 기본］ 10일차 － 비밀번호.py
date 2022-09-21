#내가 한 방법은 시간초과라...
for test_case in range(1,11):
    N, C = input().split()
    code = list(C)
    stack = []
    for c in code:
        if stack and stack[-1] == c:
            stack.pop()
        else:
            stack.append(c)
    print(f'#{test_case} {"".join(stack)}')
     
        