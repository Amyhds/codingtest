T = int(input())
for tc in range(1, T+1):
    N = list(input())
    max_N = int(''.join(N))
    min_N = int(''.join(N))
    for i in range(len(N)):
        for j in range(i+1, len(N)): 
            N[i], N[j] = N[j], N[i]
            if N[0] != '0':
                max_N = max(max_N, int("".join(N)))
                min_N = min(min_N, int("".join(N)))
            N[i], N[j] = N[j], N[i]
    print(f"#{tc} {min_N} {max_N}")