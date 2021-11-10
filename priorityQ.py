import heapq

def solution(operations):
    heap = []
    max_heap = []
    for i in range(len(operations)):
        o = operations[i].split()
        #o=I,7 o=I,5 o=I,-5 o=D,-1
        if o[0] == 'I':
            num = int(o[1])
            heapq.heappush(heap, num)
            heapq.heappush(max_heap, (-num, num))
            #heap=[-5, 7, 5]
            #max_heap=[(-7, 7),(-5, 5), (5, -5)]
        else:
            if len(heap) == 0:
                pass
            elif o[1] == '-1':
                small = heapq.heappop(heap)
                max_heap.remove((small*-1,small))
            elif o[1] == '1':
                big = heapq.heappop(max_heap)[1]
                heap.remove(big)

    if heap:
        return [heapq.heappop(max_heap)[1], heapq.heappop(heap)]
    else:
        return [0, 0]