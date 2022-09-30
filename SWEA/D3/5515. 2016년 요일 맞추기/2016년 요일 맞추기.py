T = int(input())
for tc in range(1, T+1):
    m, d = map(int, input().split())
    cal = {1: 31, 2: 29, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
    days = 0
    for i in range(1, m):
        days += cal[i]
    days += d
    whatday = days % 7
    if whatday == 1:
        print(f'#{tc} 4')
    elif whatday == 2:
        print(f'#{tc} 5')
    elif whatday == 3:
        print(f'#{tc} 6')
    elif whatday == 4:
        print(f'#{tc} 0')
    elif whatday == 5:
        print(f'#{tc} 1')
    elif whatday == 6:
        print(f'#{tc} 2')
    elif whatday == 0:
        print(f'#{tc} 3') 