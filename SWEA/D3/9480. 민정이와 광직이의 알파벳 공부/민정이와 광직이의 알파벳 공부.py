#답보고 함..부분수열의 합(1182)랑 비슷하다 DFS
def DFS(idx, used):
    global res
    
    if idx == N:
        s = ''
        for i in range(N):
            if used[i]:
                s += words[i]
        for i in range(ord('a'), ord('z') + 1):
            if chr(i) not in s:
                break
        else:
            res += 1
        return
    # 사용한 경우
    DFS(idx + 1, used)
    used[idx] = 1
    # 사용안한 경우
    DFS(idx + 1, used)
    used[idx] = 0
    

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    words = [input() for _ in range(N)]
    res = 0
    DFS(0, [0]*N)
    print(f'#{tc} {res}')