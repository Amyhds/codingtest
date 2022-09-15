from collections import deque
T = 10
for test_case in range(1, T + 1):
    t = int(input())
    num = list(map(int, input().split()))
    num = deque(num)
    cycle = 0
    minus = 1
    while True:
        if cycle == 5:
            minus = 1
            cycle = 0
        first = num.popleft()
        num.append(first - minus)
        if first - minus <= 0:
            last = num.pop()
            last = 0
            num.append(last)
            break
        minus += 1
        cycle += 1
    print('#'+str(t), end = ' ')
    for n in num:
        print(n, end = ' ')
    print()