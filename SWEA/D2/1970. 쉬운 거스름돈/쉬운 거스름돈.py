T = int(input())
money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
for test_case in range(1, T + 1):
    N = int(input())
    res = [0] * 8
    for i in range(8):
        chg = N // money[i]
        if chg > 0:
            res[i] += chg
        N = N % money[i]
    print('#'+str(test_case))
    for i in range(8):
        print(res[i], end = ' ')
    print()
