T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    tri = []
    for i in range(N):
        if i == 0:
            tri.append([1])
        if i == 1:
            tri.append([1, 1])
        if i > 1:
            a = []
            a.append(1)
            for j in range(i-1):
                a.append(tri[i-1][j]+tri[i-1][j+1])
            a.append(1)
            tri.append(a)
    print("#"+str(test_case))
    for i in tri:
        for j in i:
        	print(j, end = ' ')
        print()
            
            