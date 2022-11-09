def find_xy(p):
    plus = 1
    cur = 0
    while(cur < p):
        cur += plus 
        plus += 1
    diff = cur - p
    x = plus - 1 - diff
    y = plus - x
    return x, y

def find_p(x, y):
    total = x + y
    plus = 1
    cur = 0
    while(plus < total):
        cur += plus
        plus += 1
    diff = plus - 1 - x
    p = cur - diff
    return p

T = int(input())
for tc in range(1, T+1):
    p, q = map(int, input().split())
    px, py = find_xy(p)
    qx, qy = find_xy(q)
    X = px+qx
    Y = py+qy
    res = find_p(X, Y)
    print(f"#{tc} {res}")    