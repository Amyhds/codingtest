import sys
input = sys.stdin.readline
N, M = map(int, input().split())
idk = {}
answer = []
for _ in range(N):
    see = input().rstrip()
    idk[see] = 0
for _ in range(M):
    hear = input().rstrip()
    if hear in idk:
        answer.append(hear)
    else:
        idk[hear] = 0
answer.sort()
print(len(answer))
for a in answer:
    print(a)
