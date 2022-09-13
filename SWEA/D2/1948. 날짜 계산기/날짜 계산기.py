from datetime import datetime, timedelta
T = int(input())
for test_case in range(1, T + 1):
    first_m, first_d, second_m, second_d = map(int, input().split())
    time1 = datetime(2022, first_m, first_d)
    time2 = datetime(2022, second_m, second_d)
    res = (time2 - time1).days + 1
    print('#'+str(test_case)+' '+str(res))
    
    