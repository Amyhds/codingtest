def rotate(arr):
    new_arr = [[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N-1, -1, -1):
            new_arr[i][N-j-1] = arr[j][i]
    return new_arr

def printForm(res):
    new_res = []
    for i in range(N):
        temp = ''
        for j in range(N):
            temp += str(res[i][j])
        new_res.append(temp)
    return new_res

T = int(input())
for tc in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    arr90 = rotate(arr)
    arr180 = rotate(arr90)
    arr270 = rotate(arr180)
    res90 = printForm(arr90)
    res180 = printForm(arr180)
    res270 = printForm(arr270)
    print(f'#{tc}')
    for i in range(N):
        print(res90[i], res180[i], res270[i])