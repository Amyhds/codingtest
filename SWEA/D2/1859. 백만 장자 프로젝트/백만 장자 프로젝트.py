T = int(input())
for t in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    res = 0
    curr = arr[-1]
    for i in range(N-2, -1, -1):
        if curr > arr[i]:
            res += curr - arr[i]
        else:
            curr = arr[i]
    print("#"+str(t)+" "+str(res))
        