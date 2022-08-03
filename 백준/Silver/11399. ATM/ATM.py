N = int(input())
P = list(map(int, input().split()))
P.sort(reverse=True)
time = []
for i in range(N):
    time.append(sum(P[i:]))
print(sum(time))