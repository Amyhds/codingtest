T = int(input())
A_rate = [0]
B_rate = [0]
for tc in range(1, T+1):
    A_win, A_match, B_win, B_match = map(int, input().split())
    A_rate.append(A_win / A_match)
    B_rate.append(B_win / B_match)
for tc in range(1, T+1):
    if A_rate[tc] > B_rate[tc]:
        print(f"#{tc} ALICE")
    elif B_rate[tc] > A_rate[tc]:
        print(f"#{tc} BOB")
    else:
        print(f"#{tc} DRAW")
        
    