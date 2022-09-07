T = int(input())
def degree(arr, N):
    new_arr = [[0 for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N-1, -1, -1):
            new_arr[i][N - j - 1] = arr[j][i]
    return new_arr

def printForm(arr):
    new_arr = []
    for i in range(N):
        res = ''
        for j in range(N):
            res += str(arr[i][j])
        new_arr.append(res)
    return new_arr
    
for test_case in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    arr1 = degree(arr, N)
    arr2 = degree(arr1, N)
    arr3 = degree(arr2, N)
    res1 = printForm(arr1)
    res2 = printForm(arr2)
    res3 = printForm(arr3)    
    print('#'+str(test_case))
    for i in range(N):
        print(res1[i], res2[i], res3[i])
    
    
    