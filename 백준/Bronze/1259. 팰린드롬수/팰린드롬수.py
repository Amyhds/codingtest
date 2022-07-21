while True:
    n = input()
    if n == '0':
        break
    l = len(n)
    check = 0
    for i in range(l):
        if n[i] == n[l-1-i]:
            check += 1
    if check == l:
        print("yes")
    else:
        print("no")
    
        