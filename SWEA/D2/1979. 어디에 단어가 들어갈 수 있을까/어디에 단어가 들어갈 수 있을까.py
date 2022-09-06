T = int(input())
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    puz = [list(map(int, input().split())) for _ in range(N)]
    cnt = 0
    for i in range(N):
        hzt = 0
        for j in range(N):
            if puz[i][j] == 1:
                hzt += 1
            if puz[i][j] == 0 or j == N - 1:
                if hzt == K:
                    cnt += 1
                hzt = 0
    for i in range(N):
        vtc = 0
        for j in range(N):
            if puz[j][i] == 1:
                vtc += 1
            if puz[j][i] == 0 or j == N - 1:
                if vtc == K:
                    cnt += 1
                vtc = 0
    print('#'+str(test_case)+' '+str(cnt))
                    
                    