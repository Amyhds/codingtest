T = 10
for test_case in range(1, T + 1):
    D = int(input())
    box = list(map(int, input().split()))
    while D != 0:
        MAX = max(box)
        MIN = min(box)
        if MAX > 0:
            box[box.index(MAX)] -= 1
            box[box.index(MIN)] += 1
            D -= 1
        else:
            break
    dif = max(box) - min(box)
    print(f'#{test_case} {dif}')