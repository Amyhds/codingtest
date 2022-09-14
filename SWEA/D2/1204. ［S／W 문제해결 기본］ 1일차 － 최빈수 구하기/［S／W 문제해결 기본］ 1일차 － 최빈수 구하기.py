T = int(input())
for test_case in range(1, T + 1):
    t= int(input())
    score = list(map(int, input().split()))
    d = {}
    for s in score:
        d[s] = d.get(s, 0) + 1
    res = [k for k,v in d.items() if max(d.values()) == v]
    print(f'#{test_case} {max(res)}')