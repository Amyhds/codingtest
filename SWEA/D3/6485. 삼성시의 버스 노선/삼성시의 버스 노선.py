T = int(input())
for tc in range(1, T+1):
    N = int(input())
    bus_stop= [0] * 5001
    for i in range(N):
        A, B = map(int, input().split())
        for j in range(A, B+1):
            bus_stop[j] += 1
    P = int(input())
    res = [0] * P
    target_stop = [int(input()) for _ in range(P)]
    for i in range(P):
        res[i] = bus_stop[target_stop[i]]
    print(f"#{tc}", end = " ")
    print(*res)