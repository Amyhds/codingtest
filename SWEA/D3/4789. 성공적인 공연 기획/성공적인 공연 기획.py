T = int(input())
for tc in range(1, T+1):
    clap = input()
    hire = 0
    ppl = 0
    for i in range(len(clap)):          
        if int(clap[i]) != 0:
            if ppl >= i:
                ppl += int(clap[i])
            else:
                hire += i - ppl
                ppl = i + int(clap[i])
    print(f'#{tc} {hire}')