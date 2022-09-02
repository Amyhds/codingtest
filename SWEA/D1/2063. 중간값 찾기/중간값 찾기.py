N = int(input())
score = list(map(int, input().split()))
score.sort()
mid = score[N//2]
print(mid)