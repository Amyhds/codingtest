T = int(input())
for tc in range(1, T+1):
    S = input()
    N = len(S)
    print('..#.' * N + '.')
    print('.#.#' * N + '.')
    for i in range(N):
        print(f'#.{S[i]}.', end='')
    print('#')
    print('.#.#' * N + '.')
    print('..#.' * N + '.')
        
            