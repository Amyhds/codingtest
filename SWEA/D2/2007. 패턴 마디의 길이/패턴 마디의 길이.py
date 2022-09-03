Test = int(input())
for t in range(1, Test+1):
    string = input()
    word = ""
    length = 0
    for i in range(1, 11):
        word = string[:i]
        next_word = string[i:i*2]
        nnext_word = string[i*2:i*3]
        if word == next_word:
            length = i
            break
    print("#"+str(t)+" "+str(length))
    