a, b, c = map(int, input().split())
max = max(a, b, c)
if a==b==c:
    print(10000+a*1000)
elif a==c:
    print(1000+c*100)
elif a==b:
    print(1000+a*100)
elif b==c:
    print(1000+b*100)
else:
    print(max*100)