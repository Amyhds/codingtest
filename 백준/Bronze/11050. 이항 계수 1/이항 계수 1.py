N, K = map(int, input().split())

def facto(num):
    result = 1
    if num == 0:
        return 1
    else:
        for i in range(1, num+1):
            result *= i
        return result

print(facto(N)//(facto(K)*facto(N-K)))