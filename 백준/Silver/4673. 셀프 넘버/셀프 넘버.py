def selfnum(num):
    for n in str(num):
        num += int(n)
    return num

a = set(range(1,10001))
b = set()

for i in range(1, 10000):
    num = selfnum(i)
    if num <= 10000:
        b.add(num)

cmp = list(set(a)-set(b))                     
for i in sorted(cmp):
    print(i)