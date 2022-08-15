import sys
input = sys.stdin.readline
  
N = int(input())
array = []
for _ in range(N):
    array.append(int(input()))
array.sort()
print(round(sum(array) / N))
print(array[N//2])
d = {}
for a in array:
    d[a] = d.get(a, 0) + 1
max_value = max(d.values())
max_list = []
for i in d:
    if d[i] == max_value:
        max_list.append(i)
if len(max_list) > 1:
    print(max_list[1])
else:
    print(max_list[0])
print(max(array) - min(array))