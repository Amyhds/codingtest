from string import ascii_lowercase
alphabet = list(ascii_lowercase)

S = input()[:100]
result = []

for i in range(len(alphabet)):
    result.append(S.find(alphabet[i]))

print(*result)


