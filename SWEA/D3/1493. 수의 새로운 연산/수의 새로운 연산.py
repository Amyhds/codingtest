# 답찾아서 아이디어 얻음
def find_xy(n):
    global end
    k = 1
    if n < end[-1]:
        for i in range(len(end) - 1, -1, -1):
            if end[i-1] < n <= end[i]:
                d = i + 1
                dif = n - (1 + (d - 1) * d // 2)
                x = 1 + dif
                y = (d + 1) - x
                return x, y
    elif n == end[-1]:
        d = len(end)
        dif = n - (1 + (d - 1) * d // 2)
        x = 1 + dif
        y = (d + 1) - x
        return x, y
    else:
        while True:
            k += 1
            end.append(k * (k + 1) // 2)
            if (1 + (k - 1) * k // 2) <= n <= (k * (k + 1) // 2):
                dif = n - (1 + (k - 1) * k // 2)
                x = 1 + dif
                y = (k + 1) - x
                return x, y


T = int(input())
for test_case in range(1, T + 1):
    p, q = map(int, input().split())
    end = [1]
    px, py = find_xy(p)
    qx, qy = find_xy(q)
    X = px + qx
    Y = py + qy
    new_d = X + Y - 1
    res = 1 + (new_d - 1) * new_d // 2 + X - 1
    print(f'#{test_case} {res}')

