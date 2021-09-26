import heapq

def solution(jobs):
    answer, now, i = 0, 0, 0
    start = -1
    heap = []

    while i < len(jobs): # i는 작업 개수를 센다
        # 현재 시점에서 처리할 수 있는 작업을 heap에 저장
        for j in jobs:
            if start < j[0] <= now:
                heapq.heappush(heap, [j[1], j[0]])
                # 소요시간, 요청시기
                # 맨첨에는 [3, 0]이 들어가겠지?
        if len(heap) > 0:  # 처리할 작업이 있는 경우
            cur = heapq.heappop(heap)
            start = now
            now += cur[0] # 소요시간을 더함
            answer += (now - cur[1])
            # 작업 요청시간부터 종료시간까지의 시간 계산
            i += 1
        else:  # 처리할 작업이 없는 경우 다음 시간을 넘어감
            now += 1
    return int(answer / len(jobs))