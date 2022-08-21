import sys
input = sys.stdin.readline
N, M = map(int, input().split())
memo = {}
for _ in range(N):
    site, psw = input().split()
    memo[site] = psw
for _ in range(M):
    find_site = input().rstrip()
    print(memo[find_site])
    