T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    num = [0] * 10
    cnt = 0
    new_N = N
    while True:
        sheep = str(new_N)
        for i in range(len(sheep)):
            if num[int(sheep[i])] == 0:
                num[int(sheep[i])] += 1
        cnt += 1
        new_N = new_N + N
        if sum(num) == 10:
            break
    print('#'+str(test_case)+' '+str(N*cnt))
            