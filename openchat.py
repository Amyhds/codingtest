def solution(record):
    answer = []
    dic = {}
    for i in range(len(record)):
        r = record[i].split()
        if len(r) == 3:  #닉네임 설정 시
            dic[r[1]] = r[2]

    for i in range(len(record)):
        r = record[i].split()
        if r[0] == 'Enter':
            answer.append("%s님이 들어왔습니다."%dic[r[1]])
        elif r[0] == 'Leave':
            answer.append("%s님이 나갔습니다."%dic[r[1]])

    return answer