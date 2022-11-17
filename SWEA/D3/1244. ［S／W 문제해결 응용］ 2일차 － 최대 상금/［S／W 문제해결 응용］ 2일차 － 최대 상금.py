# 너무 어렵네...https://www.youtube.com/watch?v=vGU8h1rneGw
def dfs(n):
    global ans
    if n == count:
        ans = max(ans, int("".join(map(str, num_lst))))
        return
    for i in range(L-1):
        for j in range(i+1, L):
            num_lst[i], num_lst[j] = num_lst[j], num_lst[i]
            chk = int("".join(map(str, num_lst)))
            if (n, chk) not in visited:
                dfs(n+1)
                visited.append((n, chk))
            num_lst[i], num_lst[j] = num_lst[j], num_lst[i]
            
T = int(input())
for tc in range(1, T+1):
    num, count = input().split()
    count = int(count)
    num_lst = []
    for n in num:
        num_lst.append(int(n))
    L = len(num_lst)
    ans = 0
    visited = []
    dfs(0)
    print(f"#{tc} {ans}")