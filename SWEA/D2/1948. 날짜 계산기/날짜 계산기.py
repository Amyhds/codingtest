'''from datetime import datetime, timedelta
T = int(input())
for test_case in range(1, T + 1):
    first_m, first_d, second_m, second_d = map(int, input().split())
    time1 = datetime(2022, first_m, first_d)
    time2 = datetime(2022, second_m, second_d)
    res = (time2 - time1).days + 1
    print('#'+str(test_case)+' '+str(res))
'''
T = int(input())
d = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
for test_case in range(1, T + 1):
    m1, d1, m2, d2 = map(int, input().split())
    ans = 0
    for m in range(m1, m2):
        if m == m1:
            ans += d[m] - d1 + 1
        else:
            ans += d[m]
    ans += d2 
    print('#'+str(test_case)+' '+str(ans))
    
    