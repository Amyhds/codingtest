def solution(tickets):
    answer = []
    dic = {}
    for s, e in tickets:
        dic[s] = dic.get(s, []) + [e]
    for s in dic.keys():
        dic[s].sort(reverse=True)
        #pop할 때 알파벳 순으로 뽑아야하므로 거꾸로 해놔야함

    route = ["ICN"]
    while route:
        i = route[-1]
        if i not in dic or len(dic[i]) == 0:
            answer.append(route.pop())
            #answer에는 SFO-ATL-SFO-ICN-ATL-ICN 순으로 들어감
        else:
            route.append(dic[i][-1])
            dic[i].pop()

    answer.reverse() # 그래서 한번더 뒤집어야 답!
    return answer