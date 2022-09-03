N = int(input())
for i in range(1, N+1):
    num = str(i)
    if '3' in num or '6' in num or '9' in num:
        new_num = ''
        for j in range(len(num)):
            if num[j] == '3' or num[j] == '6' or num[j] == '9':
                new_num += '-'
        num = new_num
    print(num, end = ' ')
     
        
        