N, K = map(int, input().split())
L = list(range(1,N+1))
jsp = []
i = 0
while L:
    i += K - 1
    if i >= len(L):
        i %= len(L)
    tmp = L[i]
    L.remove(tmp)
    jsp.append(tmp)
print('<'+', '.join(map(str, jsp))+'>')