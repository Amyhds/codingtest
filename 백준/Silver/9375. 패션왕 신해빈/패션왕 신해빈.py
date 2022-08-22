T = int(input())
for _ in range(T):
    N = int(input())
    closet = {}
    answer = 1
    for _ in range(N):
        value, key = input().split()
        closet[key] = closet.get(key,0) + 1
    for key in closet:
        answer *= closet[key] + 1
    print(answer - 1)