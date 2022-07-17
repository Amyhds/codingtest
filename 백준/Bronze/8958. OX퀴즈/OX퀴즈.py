N = int(input())
for _ in range(N):
    ans = input()
    score = []
    count = 0
    for i in range(len(ans)):
        if ans[i] == 'O':
            count += 1
            score.append(count)
        else: 
            count = 0
    print(sum(score))
            
                 