# 리스트 []

# 지하철 칸별로 10명, 20명, 30명
# subway1 = 10
# subway2 = 20
# subway3 = 30

coment = "리스트\n"
subway = [10, 20,30]
print(coment, subway)

subway = ["유재석", "조세호", "박명수"]
print(subway)

# 조세호씨가 몇번 째 칸에 타고 있는가?
coment1 = "조세호씨가 몇번 째 칸에 타고 있는가?\n"
print(coment1, subway.index("조세호"))

# 하하씨가 다음 정류장에서 다음 칸에 탐
coment2 = "하하씨가 다음 정류장에서 다음 칸에 탐\n"
subway.append("하하")
print(coment2, subway)

# 졍형돈씨를 유재석 / 조세호 사이에 태워봄
coment3 = "졍형돈씨를 유재석 / 조세호 사이에 태워봄\n"
subway.insert(1, "정형돈")
print(coment3,subway)

# 지하철에 있는 사람을 한명 씩 뒤에서 꺼냄
coment4 = "지하철에 있는 사람을 한명 씩 뒤에서 꺼냄\n"
print(subway.pop())
print(coment4, subway)
# print(subway.pop())
# print(subway)
# print(subway.pop())
# print(subway)

# 같은 이름의 사람이 몇 명  있는지 확인
coment5 = "같은 이름의 사람이 몇 명  있는지 확인\n"
subway.append("유재석")
print(coment5, subway)
print(subway.count("유재석"))

# 정렬도 가능
coment6 = "정렬하기\n"
num_list  = [5, 2, 4, 3, 1]
num_list.sort()
print(coment6, num_list)

# 순서 뒤집기
coment7 = "순서뒤집기\n"
num_list.reverse()
print(coment7, num_list)

# 모두 지우기
coment8 = "모두지우기\n"
num_list.clear()
print(coment8, num_list)

# 다양한 자료형을 함께 사용 가능.
coment9 = "다양한 자료형을 함께 사용 가능.\n"
mix_list = ['조세호', 29, True]
print(coment9, mix_list)
