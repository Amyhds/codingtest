word = input()[:1000000]
word = word.upper()
count = dict()

for w in word:
    if w in count:
        count[w] += 1
    else:
        count[w] = 1

most_used = [key for key, value in count.items() if max(count.values())==value]
if len(most_used) > 1:
    print("?")
else:
    print(most_used[0])


