#리스트 데이터 타입
list1 = [0, 0, 0, 0]
print(list1[0])
list1[0] = 45
list1[1] = 33
list1[2] = 55
list1[3] = 100
list1.append(100) #리스트명.append(값): 리스트의 맨 뒤에 항목을 추가
print(list1)
total = 0
total = list1[0] + list1[1] + list1[2] + list1[3] +list1[4] 

print("list1의 합: ",total)
print("list1의 합: ",sum(list1))
#index():지정한 값ㅇ르 찾아서 해당 위치를 반환, 같은 값이 있을 때는 첫번째 인덱스를 반환
print("최대값 = %d, 최대값의 인덱스 =%d" %(max(list1),list1.index(max(list1))))
print(list1.index(100, 4)) # 4
print(list1.index(100,3)) # 3
print(list1.index(100,2,len(list1))) # 3

# count() : 리스트에서 해당 값의 개수를 반환 : 리스트명.count(값)
print("list1에서 100은 %d개가 있다" % list1.count(100))

print("================list2===================")
list2 = [] #빈리스트 생성
list2.append(2)
list2.append(3)
print(list2)

print("================list3===================")
list3 = [] #빈리스트 생성
for i in range(1,6) :
    list3.append(i)
print(list3)

print("================list4===================")
#파이썬의 list는 모든 데이터타입을 다 원소로 가질 수 있다
list4 = [10 ,20, 3.14, 'python', False]
print(list4)

print("================list4===================")
list5 =[10, 20, 30, 40, 50]
print(list5[-1]) #index값에 음수를 붙이면 리스트의 끝에서부터 탐색 & 접근
print(list5[2:4]) #0번째부터 세서 4번째는 미포함
# [ 30, 40 ] : 2번째 인덱스 ~[4-1]번째 인덱스까지
print(list5[0:4]) #0~3번째
print(list5[:3]) #처음(0)인덱스부터 3-1번째 인덱스까지
print(list5[3:]) #3번쨰부터 끝까지
print(list5[-2:-4]) #[] : 이렇게 나옴, 거꾸로 거슬러가기때문에 
print(list5[-4:-2]) #20,30
print(list5[-3:-1]) #30,40

#리스트끼리의 덧셈, 곱셈 연산
aa = [10,20,30]
bb = [40,50,60]
print(aa + bb) #[10, 20, 30, 40, 50, 60]
print(aa * 3) #[10, 20, 30, 10, 20, 30, 10, 20, 30]

cc = []
for i in range(0, 10) :
    cc.append(i)
print(cc) #[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
print(cc[:]) #[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]처음부터 끝까지
print(cc[::2]) #[0, 2, 4, 6, 8] 앞에서부터 두칸씩 건너뛰기
print(cc[::-2]) #[9, 7, 5, 3, 1]끝에서부터 두칸씩 건너뛰기
print(cc[::-1])#[9, 8, 7, 6, 5, 4, 3, 2, 1, 0] 리스트의 순서를 뒤집어 출력

cc[1:2] = [10,11]
print(cc) #[0, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9] 1대신 들어감

cc[1:4] = [21,22] #[0, 21, 22, 3, 4, 5, 6, 7, 8, 9]
print(cc)

#2차원 배열처럼 사용하기
list6 = [100,200]
list6[1] = [20,30]
print(list6) #[100, [20, 30]]

#del() :리스트에서 해당 위치의 항목을 삭제: del(리스트명[인덱스])
del(list6[1]) 
print("리스트에서 del(list6[1])실행 후 :",list6) #[100]

list6.append(200)
list6.append(200)
print(list6)
#remove() : 리스트에서 지정한 값을 삭제
#단, 지정한 값이 여러개이면 첫번째 값만 지운다
list6.remove(200)
print("list6에서 200을 remove한 후 ",list6) #[100, 200] 첫번째 200이 없어짐

print("====myList=====")
myList = [30,20,10]
print("현재 myList: %s" %myList)

myList.append(40)
print("현재 myList: %s" %myList)

print("myList에서 pop()으로 꺼내기", myList.pop()) #40
print("현재 myList: %s" %myList)

print("myList에서 pop(1)로 꺼내기", myList.pop(1)) #20

myList.append(20)
print("현재 myList : %s" %myList) # [30, 10, 20]
print(sorted(myList)) #새리스트=sorted(리스트) #[10, 20, 30]
myList.append(5)
print("현재 myList : %s" %myList) #[30, 10, 20, 5]
myList.sort() # 오름차순 정렬해주고 None반환
print("현재 myList : %s" %myList) #[5, 10, 20, 30]

#reverse() :리스트 역순으로 출력
myList.reverse()
print("reverse() 후 myList :", myList) #[30, 20, 10, 5]

#insert(인덱스, 값):인덱스번째에 값을 추가
myList.insert(2, 200) 
print("insert(2,200) 후 myList :", myList) #[30, 20, 200, 10, 5]

#extend() : 리스트 뒤에 리스트를 추가한다. 리스트명.extend(추가할 리스트)
myList.extend([1000,2000,3000])
print("extend() 후 myList:", myList) #[30, 20, 200, 10, 5, 1000, 2000, 3000] #리스트의 요소로 추가
myList.append([1000,2000,3000])
print("append() 후 myList", myList) #리스트 안에 리스트 추가

# copy() : 리스트의 내용을 새로운 리스트에 복사 :
# 새 리스트 = 리스트명.copy()
copyList = myList.copy()
print("mylist에 copy()적용 후",copyList) #[30, 20, 200, 10, 5, 1000, 2000, 3000, [1000, 2000, 3000]]
myList[1] = 2
print("myList[1] = 2 후 myList:",myList)
print("copyList:",copyList)

copyList.clear() #삭제
print("copyList clear",copyList)
