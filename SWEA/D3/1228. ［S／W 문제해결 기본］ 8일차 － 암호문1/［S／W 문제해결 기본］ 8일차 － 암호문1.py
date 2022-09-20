for t in range(1, 11):
    N = int(input())
    code = list(map(int, input().split()))
    C = int(input())
    cmd = list(input().split())
    for i in range(len(cmd)):
        if cmd[i] == 'I':
            x = int(cmd[i+1])
            y = int(cmd[i+2])
            for k in range(y):
                code.insert(x + k, int(cmd[i+2+k+1]))     
        else:
            continue
    print('#'+str(t), end = ' ')
    for i in range(10):
        print(code[i], end=' ')
    print()