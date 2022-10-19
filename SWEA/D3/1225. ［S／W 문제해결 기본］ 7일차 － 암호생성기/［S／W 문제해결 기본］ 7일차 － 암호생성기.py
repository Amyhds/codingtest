from collections import deque
for _ in range(10):
    tc = int(input())
    code = list(map(int, input().split()))
    code = deque(code)
    out = False
    while True:
        minus = 1
        for _ in range(5):
            start = code.popleft()
            temp = start - minus
            if temp <= 0:
                temp = 0
                code.append(temp)
                out = True
                break
            else:
                code.append(temp)
                minus += 1
        if out:
            break
            
    print(f'#{tc}', end=' ')
    print(*code)        