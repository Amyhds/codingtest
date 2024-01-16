n,h=map(int,input().split())
top=[]
bot=[]
go=[0]*(h+1)
go2=[0]*(h+1)
go3=[0]*(h+1)
 
for i in range (n) :
  k=int(input())
  if i %2==0: bot.append(k)
  else : top.append(k)
 
#print(bot, top)
 
 
for i in range (len(bot)) :
  go[bot[i]]+=1
  go2[  h  - top[i]  + 1 ]+=1
#print(go )
#print(go2)
 
 
for i in range( len(go)-1, 1,-1) :
  #print(i, go[i], go[i-1])
  go[i-1]+=go[i] 
#print(go)
 
for i in range (1,len(go2)):
  go2[i]+=go2[i-1]
#print(go2)
 
for i in range (1, len(go2)) :
  go3[i]=go[i]+go2[i]
 
go3.pop(0)
min_go=min(go3)
ans=go3.count(min_go)
print(min_go, ans)