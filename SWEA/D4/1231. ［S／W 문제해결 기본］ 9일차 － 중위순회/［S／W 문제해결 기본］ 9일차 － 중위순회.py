#트리순회 잘 알아두자
def inorder(x):
    global res
    if x <= N:
        inorder(x*2)
        res += alpha[x]
        inorder(x*2+1)

for tc in range(1, 11):
    N = int(input())
    alpha = {}
    res = ''
    for _ in range(N):
        cmd = input().split()
        alpha[int(cmd[0])] = cmd[1]
    inorder(1)
    print(f'#{tc} {res}')