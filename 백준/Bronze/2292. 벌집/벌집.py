N = int(input())

pile = 1
count = 1
while N > pile:
    pile += 6 * count
    count += 1
print(count)