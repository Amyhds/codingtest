expression = input().split('-') # split으로 -와 +기준으로 나눈다
# ['55', '50+40']
result = 0
for i in expression[0].split('+'):
    result += int(i)
for i in expression[1:]:
    for j in i.split('+'):
        result -= int(j)
print(result)
