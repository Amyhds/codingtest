alpha = ['ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
expr = input()
least = []
for i in range(len(expr)):
    for j in range(len(alpha)):
        if expr[i] in alpha[j]:
            least.append(j+3)
print(sum(least))
