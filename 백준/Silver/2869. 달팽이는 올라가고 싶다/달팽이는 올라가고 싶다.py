A, B, V = map(int, input().split())
days = (V-B)//(A-B)
if (V-B) % (A-B) == 0:
    print(days)
else:
    print(days + 1)
        
    
    