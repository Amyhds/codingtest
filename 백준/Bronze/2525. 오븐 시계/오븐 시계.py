h, m = map(int, input().split())
p = int(input())
p_h = p//60
p_m = p%60
hour = h + p_h
minute = m + p_m
if minute >= 60:
    hour += 1
    minute = minute - 60
if hour >= 24:
    hour = hour - 24

print(hour, minute)
    