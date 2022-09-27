from collections import deque
T = int(input())
for test_case in range(1, T+1):
    n, m = map(int, input().split())
    R = []
    W = [0]
    lot = [0]*n
    wait = deque()
    res = 0
    for i in range(n):
        R.append(int(input()))
    for i in range(m):
        W.append(int(input()))   
    for _ in range(m*2):
        car = int(input())
        if car > 0:
            for i in range(n):
                if lot[i] == 0:
                    lot[i] = car
                    res += R[i]*W[car]
                    break
            else:
                wait.append(car)                
        else:
            for i in range(n):
                if lot[i] == -1*car:
                    lot[i] = 0
                    if wait:
                        wait_car = wait.popleft()
                        lot[i] = wait_car
                        res += R[i]*W[wait_car]
                    break
    print(f'#{test_case} {res}')
                
                
                    
            