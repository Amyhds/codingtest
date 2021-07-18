word = input()
croa = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
for c in croa:
    word = word.replace(c,'*')  # *로 replace
print(len(word))