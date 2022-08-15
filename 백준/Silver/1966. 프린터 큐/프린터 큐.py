from collections import deque

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    rank = list(map(int, input().split()))
    target = [0]*N
    target = deque(target)
    target[M] = 1
    rank = deque(rank)
    out = 0
    while rank:
        if rank[0] == max(rank):
            out += 1
            if target[0] == 1:
                print(out)
                break
            else:
                rank.popleft()
                target.popleft()
        else:
            rank.append(rank.popleft())
            target.append(target.popleft())