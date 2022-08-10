N = int(input())
ppl = []
for _ in range(N):
    ppl.append(list(map(int, input().split())))
for i in ppl:
    rank = 1
    for j in ppl:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1
    print(rank, end = ' ')
    