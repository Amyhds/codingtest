from collections import deque

T = int(input())
for tc in range(1, T+1):
    n, m = map(int, input().split())
    R = [int(input()) for _ in range(n)]
    W = [int(input()) for _ in range(m)]
    park = [0] * n
    wait = deque()
    fee = 0
    for _ in range(m*2):
        car = int(input())
        if car > 0:
            for i in range(n):
                if park[i] == 0:
                    park[i] = car
                    fee += R[i] * W[car-1]
                    break
            else:
                wait.append(car)
        if car < 0:
            loc = park.index(abs(car))
            park[loc] = 0
            if wait:
                new_car = wait.popleft()
                park[loc] = new_car
                fee += R[loc] * W[new_car - 1]
    print(f"#{tc} {fee}")
                 
                