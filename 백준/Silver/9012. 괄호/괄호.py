T = int(input())
for _ in range(T):
    PS = input()
    vps = []
    for ps in PS:
        if ps == '(':
            vps.append(ps)
        elif ps == ')':
            if vps:
                vps.pop()
            else:
                print('NO')
                break
    else:
        if not vps:
            print('YES')
        else:
            print('NO')