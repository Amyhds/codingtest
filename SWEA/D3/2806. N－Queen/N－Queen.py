#답보고 함! 공부 다시!
def promising(candidate, row, col):
    for i in range(len(candidate)):
        if candidate[i] == col or abs(candidate[i] - col) == row - i:
            return False
    return True

def DFS(r, queen):
    global res

    if r == N:   #n-queen을 만족한 상태
        res += 1
        return

    for i in range(N):
        if promising(queen, r, i):
            queen.append(i)
            DFS(r+1, queen)
            queen.pop()

T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    res = 0
    DFS(0, [])
    print(f'#{test_case} {res}')