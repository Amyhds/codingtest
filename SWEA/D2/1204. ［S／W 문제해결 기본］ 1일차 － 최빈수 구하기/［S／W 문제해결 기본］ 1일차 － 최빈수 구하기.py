T = int(input())
for _ in range(1, T+1):
    tc = int(input())
    d = {}
    grade = list(map(int, input().split()))
    for i in range(1000):
        d[grade[i]] = d.get(grade[i], 0) + 1
    freq = max(d.values())
    temp = [key for key, value in d.items() if value == freq]
    print(f'#{tc} {max(temp)}')