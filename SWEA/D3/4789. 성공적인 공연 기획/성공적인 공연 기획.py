T = int(input())
for tc in range(1, T+1):
    clap_ppl = input()
    ppl = int(clap_ppl[0])
    hire = 0
    for i in range(1, len(clap_ppl)):
        if ppl < i:
            hire += i - ppl
            ppl += i - ppl
        ppl += int(clap_ppl[i])
    print(f"#{tc} {hire}")