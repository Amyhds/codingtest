N = int(input())
count = N
for i in range(N):
    word = input()
    kindOf = []
    for j in range(len(word)):
        k = ord(word[j])
        if k not in kindOf:
            kindOf.append(k)
        if k in kindOf:
            count -= 1
print(count)
