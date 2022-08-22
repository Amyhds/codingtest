S = int(input())
stair = []
dp = [] #최댓값 저장
for _ in range(S):
    stair.append(int(input()))
if S == 1:
    dp.append(stair[0]) #dp[0]
elif S == 2:
    dp.append(stair[0]) #dp[0]
    dp.append(stair[0]+stair[1]) #dp[1]
elif S == 3:
    dp.append(stair[0]) #dp[0]
    dp.append(stair[0]+stair[1]) #dp[1]
    dp.append(max(stair[0]+stair[2], stair[1]+stair[2])) #dp[2]
else:
    dp.append(stair[0]) #dp[0]
    dp.append(stair[0]+stair[1]) #dp[1]
    dp.append(max(stair[0]+stair[2], stair[1]+stair[2])) #dp[2]
    for i in range(3, S):
        dp.append(max(dp[i-3]+stair[i-1]+stair[i], dp[i-2]+stair[i]))
print(dp[S-1])    