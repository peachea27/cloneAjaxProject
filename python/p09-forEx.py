#단순 for문
for i in range(3) : #0,1,2 반복
    print("i =%d" %i)

for i in range(1,6) : #1,2,3,4,5반복(6은 미포함)
    print("i=%d" %i)

print()

#1부터 100까지의 합
sum = 0

for i in range(1,101) :
    sum += i
print("1부터 100까지의 합: %d" %sum )

#1부터 10까지의 홀수의 합

oddSum = 0
for i in range(1,11,2): #1+3+4+7+9 (step2)
    oddSum += i
print("1부터 10까지의 홀수의 합: %d" %oddSum )

#중첩 for문
#한 줄에 한 단을 찍고, 줄바꿈을 하도록 하는 구구단을 완성
#print(..., end =" ")

for i in range(2,10): #단
    for j in range(1,10):
        print("%2d x %2d = %2d" %(i,j,(i*j)), end=" ")
    print()

#while문
i = 0
while i < 3 :
    print("%d while문" %i)
    i = i + 1

j = 0
while True :
    print("hello")
    j = j + 1
    if (j ==4) :
        break

# 1 ~ 100의 합을 구하되 3의 배수는 제외
sum2 =0
for i in range(1,101):
    if((i % 3) == 0) :
        continue
    sum2 +=i
        
print("1~100까지의 합, 3의 배수 제외 : %d" %sum2)

#pass
m = 0
while m < 10:
    m += 1
    if m % 2 == 0 :
        print("pre pass :", m)
        pass
    # print(m)

