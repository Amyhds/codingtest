def solution(N, number):
    nlist = [set() for _ in range(9)]  # 0~8
    # 횟수가 8번 이하여야 하므로
    for i in range(1, 9):  # 1~8
        nlist[i].add(int(str(N) * i)) # 1번째에는 5, 2번째에는 55, ...
        for j in range(1, i):  # 1~8
            for x in nlist[j]:  # 1~8
                for y in nlist[i - j]:  # 0~7
                    nlist[i].add(x + y)
                    nlist[i].add(x - y)
                    nlist[i].add(x * y)
                    if y != 0:
                        nlist[i].add(int(x // y))
                        
                    # 전단계에 사칙연산하면 다음 단계임
        if number in nlist[i]:
            return i
    return -1