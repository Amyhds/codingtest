T = int(input())
for test_case in range(1, T+1):
    words = []
    max_l = 0
    new_w = ''
    for _ in range(5):
        w = input()
        words.append(w)
        if max_l < len(w):
            max_l = len(w)
    for i in range(max_l):
        for j in range(5):
            if len(words[j]) > i:
                new_w += words[j][i]
    print(f'#{test_case} {new_w}')