str="우리나라 대한민국"
print(str[1:3])
print(str + "아름답다")
str = '최고' * 5
print(str)
print(len(str))

#str[0] ='너'
#print(str)

str = "Python is the Best programming language"
print(str.upper())
print(str.lower())
print(str.swapcase()) #소문자 ->대문자 대문자->소문자
print(str.title()) #단어마다 첫글자를 대문자

str = "Python is very simple. 정말? Python이 그래?"
print(str.count("Python")) #2
print(str.find("Python")) # 0 ~ indexOf()와 유사

print(str.rfind("Python")) # 27 lastIndexOf와 유사
print(str.index("is"))

print(str.find("good")) #찾는 단어가 없으면 -1반환
print(str.startswith("Python")) #문자열이 해당단어로 시작하는지 여부 boolean으로 반환
print(str.endswith("정말"))

str="  파   이   썬   "
print(str.strip()) #앞 뒤 공백 모두 제거
print("["+str+"]")
print("[" +str.rstrip() + "]") #뒤 공백 제거
print("[" +str.lstrip() + "]") #앞 공백 제거
print(str.replace(" ","")) #중간공백까지 다 제거

str="하나:둘:셋:넷"
print(str.split(":")) # :으로 문자열을 나눠서 리스트로 반환

before = ['2023','04','33']
#before리스트의 모든 원소를 꺼내서 int()로 변환(''없어짐)
after = list(map(int,before))
print(after) #[2023, 4, 33]

print('1234'.isdigit()) #숫자 형식이냐? #t
print('abcd'.isdigit()) #f
print('abcd'.islower()) #t
print('  '.isspace()) #t
print('a1b2c3'.isalnum()) #t
print('1234'.isalpha()) #f
