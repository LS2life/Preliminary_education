
# ! if문
# weather = input("오늘 날씨는 어때요?")
# if weather == "비" or weather == "눈":
#     print("우산을 챙기세요")
# elif weather == "미세먼지":
#     print("마스크를 챙기세요")
# else:
#     print("준비물은 필요 없어요")

# temp = int(input("기온은 어때요? "))
# if 30 <= temp:
#     print("너무 더워요. 나가지 마세요")
# elif 10 <= temp and temp < 30:
#     print("괜찮은 날씨에요")
# elif 0 <= temp < 10:
#     print("외투를 챙기세요")
# else:
#     print("너무 추워요. 나가지 마세요.")
#     20



# ! for문
# for waiting_no in [0, 1, 2, 3, 4]:
#     print("대기번호 : {0}".format(waiting_no))
# * randrange()
print(" -- for문 예시 -- ")
for waiting_no in range(1, 6):
    print("대기번호 : {0}".format(waiting_no))

starbucks = ["아이언맨", "토르", "그루트", "헐크", "스파이더맨"]
for customer in starbucks:
    print("{0}님, 커피가 준비되었습니다.".format(customer))



# ! 한줄 for문
#  출석번호가 1 2 3 4 , 앞에 100을 붙이기로 함 -> 101, 102, 103, 104.
print(" -- 한 줄 for 문 예시 --")
print("  < 더하기 100 >")
students = [1,2,3,4,5]
print(students)
students = [i+100 for i in students]
print(students)

# 학생 이름을 길이로 변환
print("  < 학생 이름을 길이로 변환 >")
students = ["Iron man", "Thor", "I ma groot"] 
students = [len(i) for i in students]
print(students)

# 학생 이름을 대문자로 변환
print("  < 학생이름을 대문자로 변환 >")
students = ["Iron man", "Thor", "I ma groot"] 
students = [i.upper() for i in students]
print(students)

# ! while문
print(" -- while문 예시 -- ")
customer = "토르"
index = 5
while index >= 1:
    print("{0} 님, 커피가 준비 되었습니다. {1} 번 남았어요.".format(customer, index))
    index -= 1
    if index == 0:
        print("커피는 폐기처분되었습니다.")

customer = "토르"
person = "Unknown"

# while person != customer:
    # print("{0} 님, 커피가 준비 되었습니다.".format(customer))
    # person = input("이름이 어떻게 되세요?")



# ! continue 와 break
print(" -- continue 와 break -- ")
# 결석
absent = [2, 5]
# 책이 없어
no_book = [7]

for student in range(1, 11):
    if student in absent:
        continue
    elif student in no_book:
        print("오늘 수업 안한다. {0}는 옥땅으로 따라와".format(student))
        break
    print("{0}, 책 읽어".format(student))

