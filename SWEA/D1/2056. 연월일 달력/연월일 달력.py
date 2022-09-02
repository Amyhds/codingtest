T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    ymd = input()
    y = ''
    m = ''
    d = ''
    res = ''
    for i in range(0, 4):
        y += ymd[i]
    for i in range(4, 6):
        m += ymd[i]
    for i in range(6, 8):
        d += ymd[i]
    month = int(m)
    date = int(d)
    if month < 1 or month > 12 or date < 1 or date > 31:
        res = '-1'
    else:
        if month == 2:
            if date > 28:
                res = '-1'
        elif month == 4:
            if date > 30:
                res = '-1'
        elif month == 6:
            if date > 30:
                res = '-1'
        elif month == 9:
            if date > 30:
                res = '-1'
        elif month == 11:
            if date > 30:
                res = '-1'
    if res != '-1':
        res = y+'/'+m+'/'+d
    print('#'+str(test_case)+' '+res)
            
        
