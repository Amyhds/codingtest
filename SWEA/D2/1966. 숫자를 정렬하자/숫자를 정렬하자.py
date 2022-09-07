T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    res = ''
    for i in range(N):
        res += str(arr[i])
        res += ' '
    print('#'+str(test_case)+' '+res)
        
