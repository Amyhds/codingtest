T = int(input())
for test_case in range(1, T+1):
    word = input()
    vowel = ['a', 'e', 'i', 'o', 'u']
    res = ''
    for i in range(len(word)):
        if word[i] not in vowel:
            res += word[i]
    print(f'#{test_case} {res}')
    