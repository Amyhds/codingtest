''' 예제 1,2만 통과
from collections import deque

def solution(priorities, location):
    answer = 0
    que = deque(priorities)
    for _ in range(len(que)):
        if que[0] < max(que):
            first = que.popleft()
            que.append(first)
            if location == 0:
                location += len(que) - 1
            else:
                location -= 1
    return location + 1
'''

from collections import deque

def solution(priorities, location):
    que = deque([(i, v) for i, v in enumerate(priorities)])
    order = []
    while que:
        first = que.popleft()
        if first[1] == max(priorities):
            order.append(first[0])
            priorities.remove(max(priorities))
        else:
            que.append(first)

    return order.index(location) + 1


