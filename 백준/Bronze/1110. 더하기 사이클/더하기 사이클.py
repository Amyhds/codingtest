n = int(input())
num = n
count = 0

while True:
    ten = num//10
    one = num%10
    x = ten + one #10의 자릿수 + 1의 자릿수
    num = one*10 + x%10
    count += 1
    
    if num == n:
        break
print(count)


    