#어렵게 생각하지 말기! 풀이 참고
def isDigit(x):
    if x.isdigit():
        return True
    else:
        return False
for tc in range(1, 11):
    N = int(input())
    stack = []
    stack.append(0)
    res = 0
    for _ in range(N):
        temp = input().split()
        stack.append(temp[1])
    for i in range(N, N//2, -1):
        if not isDigit(stack[i]):
            res = 0
            break
    else:
        res = 1
    for i in range(1, N//2+1):
        if isDigit(stack[i]):
            res = 0
            break
    else:
        res = 1
    print(f'#{tc} {res}')