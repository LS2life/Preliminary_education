
# ! 리스트 []

# 지하철 칸별로 10명, 20명, 30명
# subway1 = 10
# subway2 = 20
# subway3 = 30
coment = "리스트\n"
subway = [10, 20,30]
print(coment, subway)

subway = ["유재석", "조세호", "박명수"]
print(subway)

# & 조세호씨가 몇번 째 칸에 타고 있는가?
coment1 = "조세호씨가 몇번 째 칸에 타고 있는가?\n"
print(coment1, subway.index("조세호"))

# & 하하씨가 다음 정류장에서 다음 칸에 탐
coment2 = "하하씨가 다음 정류장에서 다음 칸에 탐\n"
subway.append("하하")
print(coment2, subway)

# & 졍형돈씨를 유재석 / 조세호 사이에 태워봄
coment3 = "졍형돈씨를 유재석 / 조세호 사이에 태워봄\n"
subway.insert(1, "정형돈")
print(coment3,subway)

# & 지하철에 있는 사람을 한명 씩 뒤에서 꺼냄
coment4 = "지하철에 있는 사람을 한명 씩 뒤에서 꺼냄\n"
print(subway.pop())
print(coment4, subway)
# print(subway.pop())
# print(subway)
# print(subway.pop())
# print(subway)

# & 같은 이름의 사람이 몇 명  있는지 확인
coment5 = "같은 이름의 사람이 몇 명  있는지 확인\n"
subway.append("유재석")
print(coment5, subway)
print(subway.count("유재석"))

# & 정렬도 가능
coment6 = "정렬하기\n"
num_list  = [5, 2, 4, 3, 1]
num_list.sort()
print(coment6, num_list)

# * 순서 뒤집기
coment7 = "순서뒤집기\n"
num_list.reverse()
print(coment7, num_list)

# * 모두 지우기
coment8 = "모두지우기\n"
num_list.clear()
print(coment8, num_list)

# * 다양한 자료형을 함께 사용 가능.
coment9 = "다양한 자료형을 함께 사용 가능.\n"
num_list = [5, 2, 4, 3, 1]
mix_list = ['조세호', 29, True]
print(coment9, mix_list)

# * 리스트 확장
num_list.extend(mix_list)
print(num_list)



# ! 딕셔너리
cabinet =  {3:"유재석", 100:"김태호"}
# print(cabinet[3])
# print(cabinet[100])
# print(cabinet.get(3))

# * 중괄호 [] 사용시 값이 없으면 에러 발생하고 종료.
# print(cabinet[5])

# * get() 사용시 값이 없으면 None으로 출력
print(cabinet.get(5))
print(cabinet.get(5), "사용 가능")
print("hi")

# * 사전자료형 내부 키가 있는지 확인
# Ture
print(3 in cabinet)
# False
print(5 in cabinet)

cabinet = {"A-3":"유재석", "B-100":"김태호"}
print(cabinet["A-3"])
print(cabinet["B-100"])

# * 새 손님

cabinet["A-3"] = "김종국"
cabinet["C-20"] = "조세호"
print(cabinet)

# * 간 손님
del cabinet["A-3"]
print(cabinet)

# * key 들만 출력
print(cabinet.keys())

# * value 들만 출력
print(cabinet.values())

# * key, value 쌍으로 출력
print(cabinet.items())

# * 목욕탕 폐점
cabinet.clear()
print(cabinet)



# ! 튜플

menu = ("돈까스", "치즈까스")
# * 추가 불가
# menu.add("생선까스")

# * 한꺼번에 생성가능
(name, age, hobby) = "김종국", 20, "돈까스"
print (name, age, hobby)



# ! 집합(set)
# * 중복 안됨, 순서 없음
my_set = {1, 2, 3, 3, 3}
print(my_set)

java = {"유재석", "김태호", "양세형"}
python = set(["유재석", "박명수"])

# 교집합 (java 와 python 으 ㄹ모두 할 수 있는 개발자) 
print(java & python)
print(java.intersection(python))

# 합집합 (java 할 수 있거나 python 을 할 수 있는 개발자)
print(java | python)
print(java.union(python))

# 차집합 (java 할 수 있지만 python 은 할 줄 모르는 개발자)
print(java - python)
print(java.difference(python))

# python을 할 줄 아는 사람이 늘어남
python.add("김태호")
print(python)

# java 를 잊었어요
java.remove("김태호")
print(java)

# ! 자료구조의 변경
menu = {"커피", "우유", "주스"}
print(menu, type(menu))

menu = list(menu)
print(menu, type(menu))

menu = tuple(menu)
print(menu, type(menu))

menu = set(menu)
print(menu, type(menu))











