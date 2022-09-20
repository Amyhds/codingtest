T = int(input())
for test_case in range(1, T + 1):
    mem = input()
    L = len(mem)
    reset = ['0'] * L
    cnt = 0
    for i in range(L):
        if reset[i] != mem[i]:
            for j in range(i, L):
                 reset[j] = mem[i]
            cnt += 1
    print(f'#{test_case} {cnt}')
    
