a = 99

if(a < 100) :
    print("a는 100보다 작다")
else:
    print("a는 100보다 작지 않다")

if a < 100 : 
    print("a는 100보다 작다")
elif a == 100 :
    print("a는 100과 같다")
else:
    print("a는 100보다 크다")

#리스트와 함께 사용하는 if문
favoriteFruits =['수박','귤','참외','포도','딸기']

if '딸기' in favoriteFruits :
    print("딸기가 리스트에 있습니다")
if '샤인머스캣' not in favoriteFruits :
    print("샤인머스캣이 리스트에 없습니다")

