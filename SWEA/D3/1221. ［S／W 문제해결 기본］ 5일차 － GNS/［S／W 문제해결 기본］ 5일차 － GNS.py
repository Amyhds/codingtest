T = int(input())
for test_case in range(1, T+1):
    tc, n = input().split()
    n = int(n)
    D1 = {"ZRO" : 0, "ONE" : 1, "TWO" : 2, "THR" : 3, "FOR" : 4, "FIV" : 5, "SIX" : 6, "SVN" : 7, "EGT" : 8, "NIN" : 9}
    D2 = {0: "ZRO", 1: "ONE", 2: "TWO", 3: "THR", 4: "FOR", 5: "FIV", 6: "SIX", 7: "SVN", 8: "EGT", 9: "NIN"}
    lst = list(input().split())
    num = []
    string = []
    for i in range(n):
        num.append(D1[lst[i]])
    num.sort()
    for i in range(n):
        string.append(D2[num[i]])
    print(tc)
    for i in range(n):
        print(string[i], end = ' ')