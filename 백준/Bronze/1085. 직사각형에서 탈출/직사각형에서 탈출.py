x, y, w, h = map(int, input().split())
dx = w - x
dy = h - y
m = min(x, y, dx, dy)
print(m)