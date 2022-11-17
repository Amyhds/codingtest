T = int(input())
res = []
for _ in range(T):
    a1, a2, b1, b2 = map(int, input().split())
    if a1/a2 > b1/b2:
        res.append('ALICE')
    elif a1/a2 < b1/b2:
        res.append('BOB')
    else:
        res.append('DRAW')
for i in range(len(res)):
    print(f'#{i+1} {res[i]}')