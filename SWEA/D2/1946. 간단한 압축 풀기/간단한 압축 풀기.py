T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    doc = ''
    for _ in range(N):
        C, K = input().split()
        for _ in range(int(K)):
            doc += C
    print('#'+str(test_case))
    if len(doc) <= 10:
        print(doc)
    else:
        start = 0
        end = 10
        while True:
            print(doc[start:end], end='\n')
            if len(doc[end:]) < 10:
                print(doc[end:])
                break
            else:
                start = end
                end += 10