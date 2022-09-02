#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    nums = list(map(int, input().split()))
    S = sum(nums)/10
    AVG = round(S)
    print('#'+str(test_case)+' '+str(AVG)) 
    # ///////////////////////////////////////////////////////////////////////////////////