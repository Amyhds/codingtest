a = []
for i in range(9):
    k = int(input())
    a.append(k)    
m = max(a)
print(m)
print(a.index(m) + 1)