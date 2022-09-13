decode = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
          'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/']
T = int(input())
for test_case in range(1, T + 1):
    word = input()
    bin_res = ''
    ans = ''
    for i in range(len(word)):
        num = decode.index(word[i])
        bin_num = str(bin(num)[2:])
        while len(bin_num) < 6:
            bin_num = '0' + bin_num
        bin_res += bin_num
    for j in range(0, len(bin_res), 8):
        dec = int(bin_res[j:j+8] , 2)
        ans += chr(dec)
    print('#'+str(test_case)+' '+ans)
        
    