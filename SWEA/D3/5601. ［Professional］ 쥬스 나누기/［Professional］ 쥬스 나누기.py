T = int(input())
for tc in range(1, T+1):
    N = int(input())
    print('#'+str(tc), end = ' ')
    for _ in range(N):
        print(f'1/{N}', end = ' ')
    print()