N, M = map(int, input().split())
cards = list(map(int, input().split()))
sum_list = []
for i in range(0, N-2):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
            sum = cards[i]+cards[j]+cards[k]
            sum_list.append(sum)
sum_list.sort(reverse=True)
for i in range(len(sum_list)):
    if sum_list[i] <= M:
        print(sum_list[i])
        break