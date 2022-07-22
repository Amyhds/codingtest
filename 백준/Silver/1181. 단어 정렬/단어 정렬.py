N = int(input())
words = set()
for _ in range(N):
    n = input()
    words.add(n)
words = list(words)
words.sort()
words.sort(key=len)

for w in words:
    print(w)