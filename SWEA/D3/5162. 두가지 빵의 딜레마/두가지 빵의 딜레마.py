#최소금액 빵을 최대한 많이 사면 되는 것이었다...
T = int(input())
for tc in range(1, T+1):
    A, B, C = map(int, input().split())
    print(f'#{tc} {C//min(A,B)}')