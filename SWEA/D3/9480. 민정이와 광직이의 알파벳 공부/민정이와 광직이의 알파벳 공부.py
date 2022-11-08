def DFS(index, used):
    global result
    if index == N:
        temp = ''
        for i in range(N):
            if used[i]:
                temp += words[i]
        for j in range(ord('a'), ord('z')+1):
            if chr(j) not in temp:
                break
        else:
            result += 1
        return
    
    used[index] = 1
    DFS(index+1, used)
    used[index] = 0
    DFS(index+1, used)

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    words = [input() for _ in range(N)]
    used = [0]*N
    result = 0
    DFS(0, used)    
    print(f"#{tc} {result}")