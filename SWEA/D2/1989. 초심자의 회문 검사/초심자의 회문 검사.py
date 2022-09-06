T = int(input())
for test_case in range(1, T + 1):
    word = input()
    if word == word[::-1]:
        res = '1'
    else:
        res = '0'
    print('#'+str(test_case)+' '+res)