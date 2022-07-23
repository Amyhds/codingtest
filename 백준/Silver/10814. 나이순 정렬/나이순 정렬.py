N = int(input())
member = []
for _ in range(N):
    member.append(list(input().split()))
member.sort(key=lambda x:int(x[0]))
for m in member:
    print(m[0], m[1])