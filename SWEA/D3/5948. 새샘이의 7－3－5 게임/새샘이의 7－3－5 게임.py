T = int(input())
for tc in range(1, T+1):
    lst = list(map(int, input().split()))
    sum_lst = set()
    for i in range(5):
        for j in range(i+1, 7):
            for k in range(j+1, 7):
                sum_lst.add(lst[i] + lst[j] + lst[k])
    sum_lst = list(sum_lst)
    sum_lst.sort(reverse = True)
    print(f'#{tc} {sum_lst[4]}')