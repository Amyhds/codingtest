T = int(input())
for test_case in range(1, T+1):
    have = input()
    S = [0]*14
    D = [0]*14
    H = [0]*14
    C = [0]*14
    error = False
    for i in range(0, len(have)-1, 3):
        if have[i] == 'S':
            idx = int(have[i+1:i+3])
            S[idx] += 1
            if S[idx] > 1:
                error = True
                break
        elif have[i] == 'D':
            idx = int(have[i+1:i+3])
            D[idx] += 1
            if D[idx] > 1:
                error = True
                break
        elif have[i] == 'H':
            idx = int(have[i+1:i+3])
            H[idx] += 1
            if H[idx] > 1:
                error = True
                break
        elif have[i] == 'C':
            idx = int(have[i+1:i+3])
            C[idx] += 1
            if C[idx] > 1:
                error = True
                break
    if error:
        print(f'#{test_case} ERROR')
    else:
        print(f'#{test_case} {13 - sum(S)} {13 - sum(D)} {13 - sum(H)} {13 - sum(C)}')