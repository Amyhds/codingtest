from collections import deque
N = int(input())
cards = deque([i for i in range(1, N+1)])
while len(cards)>1:
    cards.popleft() #2,3,4,5,6
    tmp = cards.popleft() #3,4,5,6,
    cards.append(tmp) #3,4,5,6,2
print(cards[0])