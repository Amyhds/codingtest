def solution(progresses, speeds):
    answer = []
    days = []
    for i in range(len(progresses)):
        remain = (100 - progresses[i]) % speeds[i]
        quo = (100 - progresses[i]) // speeds[i]
        if remain == 0:
            days.append(quo)
        elif remain > 0:
            days.append(quo+1)
    maxday = 0
    for i in range(len(days)):
        if maxday < days[i]:
            maxday = days[i]
            answer.append(1)
        else:
            last = answer.pop()
            last += 1
            answer.append(last)
    return answer

progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]
solution(progresses, speeds)

''' 단 pop(0)는 O(n)만큼 시간이 걸림...
def solution(progresses, speeds):
    answer = []
    time = 0
    count = 0
    while len(progresses)> 0:
        if (progresses[0] + time*speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
    answer.append(count)
    return answer
    
    
제일 좋은 풀이?!
def solution(progresses, speeds):
    Q=[]
    for p, s in zip(progresses, speeds):
        if len(Q)==0 or Q[-1][0]<-((p-100)//s):
            Q.append([-((p-100)//s),1])
        else:
            Q[-1][1]+=1
    return [q[1] for q in Q]
'''