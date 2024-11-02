print("Hello world")

print(5 >10)
print(1+1)

jumin = "990120-1234567"

print("성별 : " + jumin[7])
print("연 : " + jumin[0:2])
print("월 : " + jumin[2:4])
print("일: " + jumin[4:6])

print("생년월일 : " + jumin[:6])
print("뒤 7자리 : " + jumin[7:])



python = "Python is Amazing"
# 소문자
print(python.lower())
# 대문자
print(python.upper())
# 대문자가 있는지 
print(python[0].isupper())
# 문자 수정
print(python.replace("Python", "Java"))
# n 의 위치
index = python.index("n")
print(index)
# n의 위치 + 1
index = python.index("n", index + 1)
print(index)
# 없으면 -1 출력
print(python.find(("Java")))
# 없으면 에러메세지 출력
# print(python.index(("Java")))
print("hi")
# 해당 문자가 몇개있는지 카운트
print(python.count(("n")))



# 문자열 포멧
print("a" + "b")
print("a", "b")

# 방법1
print("나는 %d살입니다." % 38)
print("나는 %s를 좋아해요" % "파이썬")
print("나는 %s색과 %s색을 좋아해요." % ("파란", "빨간"))
# 방법2
print("나는 {}살 입니다.".format(38))
print("나는 {}색과 {}색을 좋아해요.".format("파란", "빨간"))
print("나는 {0}색과 {1}색을 좋아해요.".format("파란", "빨간"))
print("나는 {1}색과 {0}색을 좋아해요.".format("파란", "빨간"))
# 방법3
print("나는 {age}살이며, {color}색을 좋아해요.".format(age = 20, color = "빨간"))
print("나는 {age}살이며, {color}색을 좋아해요.".format(color = "빨간", age = 20))
# 방법4 (v3.6 이상~)
age = 20
color = "빨간"
print(f"나는 {age} 살이며, {color}색을 좋아해요.")



# 탈출문자
# \n : 줄바꿈
print("백문 불여일견 백견 불여일타")
# \" \' : 문장 내에서 따옴표
# 저는 "에드워드 토니 스타크"입니다.
print("저는 '에드워드 토니 스타크'입니다.")
print('저는 "에드워드 토니 스타크"입니다.')
print("저는 \"에드워드 토니 스타크\"입니다.")
print("저는 \'에드워드 토니 스타크\'입니다.")
# \\ : 문장 내에서 \
print("C:\\Users\\Tony\\Desktop>")
# \r : 커서를 맨 앞으로 이동
print("Red Apple\rPine")
# \b : 백스페이스 (한 글자 삭제)
print("Redd\bApple")
# \t : 탭
print("Red\tApple")






