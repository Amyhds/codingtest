# 답보고 함...이런 유형 잘 알아두자 햄버거 다이어트랑 비슷!!!!
def DFS(idx, total):
    global res
    if idx == N:
        return
    temp = total + A[idx]
    if temp == K:
        res += 1
    DFS(idx+1, total)
    DFS(idx+1, temp)
    
T = int(input())
for test_case in range(1, T+1):
    N, K = map(int, input().split())
    A = list(map(int, input().split()))
    res = 0
    DFS(0, 0)
    print(f'#{test_case} {res}')