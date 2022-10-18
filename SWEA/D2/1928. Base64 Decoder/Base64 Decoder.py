decode = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
          'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/']
T = int(input())
for tc in range(1, T + 1):
    string = input()
    res = ''
    ans = ''
    for i in range(len(string)):
        temp = decode.index(string[i])
        bin_num = str(bin(temp)[2:])
        while len(bin_num) < 6:
            bin_num = '0' + bin_num
        res += bin_num
    for i in range(0, len(res), 8):
        temp = int(res[i:i+8] , 2)
        ans += chr(temp)
    print(f'#{tc} {ans}')    
        