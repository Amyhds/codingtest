def Power(n, k):
    if k == 0:
        return 1
    if k % 2:
        return (Power(n, k//2) ** 2 * n) % P
    else:
        return (Power(n, k//2) ** 2) % P
    
T = int(input())
for test_case in range(1, T+1):
    N, R = map(int, input().split())
    P = 1234567891
    Fac = [1 for _ in range(N + 1)]
    for i in range(2, N + 1):
        Fac[i] = Fac[i - 1] * i % P
    A = Fac[N]
    B = (Fac[R] * Fac[N-R]) % P # 얘도 곱셈이니까 모듈러연산 적용?
    ans = (A % P) * (Power(B, P-2) % P) % P 
    print(f'#{test_case} {ans}')
    