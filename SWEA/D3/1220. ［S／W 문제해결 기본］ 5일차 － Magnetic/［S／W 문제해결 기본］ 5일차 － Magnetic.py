for t in range(1, 11):
    L = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    res = 0
    for i in range(100):
        target = ''
        for j in range(100):
            if arr[j][i] != 0:
                target += str(arr[j][i])
        if '12' in target:
            for k in range(len(target)):
                if target[k:k+2] == '12':
                    res += 1
    print(f'#{t} {res}')
             
        