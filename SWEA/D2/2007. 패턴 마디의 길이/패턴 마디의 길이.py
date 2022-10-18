T = int(input())
for tc in range(1, T+1):
    string = input()
    length = 0
    for i in range(1, 11):
        w1 = string[:i]
        w2 = string[i:i*2]
        w3 = string[i*2:i*3]
        if w1 == w2 and w2 == w3:
            length = i
            break
    print(f'#{tc} {length}')        