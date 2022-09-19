for _ in range(10):
    T = int(input())
    target = input()
    String = input()
    res = 0
    if target not in String:
        print(f'#{T} {res}')
    else:
        for i in range(len(String) - len(target) + 1):
            if String[i:i+len(target)] == target:
                res += 1
    print(f'#{T} {res}')