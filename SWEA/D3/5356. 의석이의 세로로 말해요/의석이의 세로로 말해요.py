T = int(input())
for tc in range(1, T+1):
    five_words = []
    max_length = 0
    result = ''
    for _ in range(5):
        word = input()
        five_words.append(word)
        if max_length < len(word):
            max_length = len(word)
    for i in range(max_length):
        for j in range(5):
            if len(five_words[j]) > i:
                result += five_words[j][i]
    print(f"#{tc} {result}")