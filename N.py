def solution(N, number):
    nlist = [set() for _ in range(9)]  # 0~8
    for i in range(1, 9):  # 1~8
        nlist[i].add(int(str(N) * i))
        for j in range(1, i):  # 1~8
            for x in nlist[j]:  # 1~8
                for y in nlist[i - j]:  # 0~7
                    nlist[i].add(x + y)
                    nlist[i].add(x - y)
                    nlist[i].add(x * y)
                    if y != 0:
                        nlist[i].add(int(x // y))
        if number in nlist[i]:
            return i
    return -1