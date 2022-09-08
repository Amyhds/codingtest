T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    ans = 0
    if len(A) < len(B):
        s = A
        l = B
    elif len(B) < len(A):
        s = B
        l = A
    else:
    	for i in range(N):
            ans += A[i] * B[i]
            print('#'+str(test_case)+' '+str(ans))
            break
    for k in range(abs(N-M)+1):
        temp = 0
        for i in range(len(s)):
            temp += s[i] * l[i + k]
        if temp > ans:
            ans = temp
    print('#'+str(test_case)+' '+str(ans))
     
                
                
        