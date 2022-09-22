T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    bus = {}
    for i in range(1,5001):
        bus[i] = 0
    for i in range(N):
        A, B = map(int, input().split())
        for j in range(A, B+1):
            bus[j] += 1
    P = int(input())
    stop = []
    for i in range(P):
        stop.append(int(input()))
    print('#'+str(test_case), end = ' ')
    for j in range(P):
        print(bus[stop[j]], end = ' ')
    print()