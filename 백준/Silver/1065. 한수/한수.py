def han(N):
    k = 0
    for n in range(1, N+1):  # n = 1, 2, ..., 210
        l = list(map(int, str(n))) # l = [1],[2], ..., [2,1,0]
        if n < 100:
            k += 1
        elif l[0]-l[1]==l[1]-l[2]:
            k += 1
    return k

N = int(input())
print(han(N))
    