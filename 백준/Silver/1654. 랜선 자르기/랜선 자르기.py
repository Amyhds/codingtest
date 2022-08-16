import sys
input = sys.stdin.readline
K, N = map(int, input().split())
k_list = []
for _ in range(K):
    k_list.append(int(input()))
start = 1
end = max(k_list)
while start <= end:
    res = 0
    mid = (start + end) // 2
    for i in range(K):
        res += k_list[i] // mid
    if res >= N:
        start = mid + 1
    else:
        end = mid - 1
print(end)
