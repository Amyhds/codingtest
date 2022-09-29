T = int(input())
for tc in range(1, T+1):
    N = int(input())
    print('#'+str(tc), end=' ')
    if N%2 == 0:
        print('Even', end=' ')
    else:
        print('Odd', end=' ')
    print()