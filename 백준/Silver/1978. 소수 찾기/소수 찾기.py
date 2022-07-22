N = int(input())
L = list(map(int, input().split()))
count = 0
for num in L:
    prime = True
    if num == 1:
        prime = False
    for i in range(2, num):
        if num % i == 0:
            prime = False
            break
    if prime == True:
        count += 1
print(count)
    