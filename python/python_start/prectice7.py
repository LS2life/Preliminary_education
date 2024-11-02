print("Python", "Java", "JavaScript", sep=", ")
print("Python", "Java", "JavaScript", sep=" ")

print("Python", "Java", sep=" ", end="? ")
print("무엇이 더 재밌을까요?")

# import sys
# print("Python", "Java", file=sys.stdout)
# print("Python", "Java", file=sys.stderr)

scores = {"수학":0, "영어":50, "코딩":100}
for subject, score in scores.items():
    # print(subject, score)
    print(subject.ljust(4), score)
    print(subject.rjust(4), score)
    print(subject.ljust(4), str(score).rjust(4), sep=":")
    print(subject.ljust(4), str(score).rjust(8), sep=":")

# 은행 대기순번표
for num in range(1, 21):
    print("대기번호 : " + str(num).zfill(3))

# input은 들어오는 값을 모두 string으로 저장한다.

#! 다양한 출력 포맷
# # 빈 자리는 빈공간으로 두고, 오른쪽 정렬을 하되, 총 10자리 공간을 확보
# print("{0: >10}".format(500))
# # 양수일 때 +로 표시, 음수일 때 -로 표시
# print("{0: >+10}".format(500))
# print("{0: >+10}".format(-500))
# # 왼쪽 정렬하고, 빈칸으로 _로 채움
# print("{0:_<10}".format(500))
# # 3자리 마다 콤마를 찍어주기
# print("{0:,}".format(1000000000000000))
# # 3자리 마다 콤마를 찍어주기, +- 부호도 붙이기
# print("{0:+,}".format(1000000000000000))
# print("{0:+,}".format(-1000000000000000))
# # 3자리 마다 콤마를 찍어주기, 부호도 붙이고, 자릿수 확보
# # 돈이 많으면 행복하니 까 빈자리는 ^로 채워주기
# print("{0:^<+30,}".format(1000000000000000))
# # 소수점 출력
# print("{0:f}".format(5/3))
# # 소수점 특정 자리수까지만 표시 (소수점 3째 자리에서 반올림)
# print("{0:.2f}".format(5/3))


#! 파일입출력
#* 파일 쓰기
# score_file = open("score.txt", "w", encoding="utf8")
# print("수학 : 0", file=score_file)
# print("영어 : 50", file=score_file)
# score_file.close()

#* 파일에 추가로 쓰기
# score_file = open("score.txt", "a", encoding="utf8")
# score_file.write("과학 : 80")
# score_file.write("\n코딩 : 100")
# score_file.close()

#* 파일 읽기
# score_file = open("score.txt", "r", encoding="utf8")
# print((score_file.read()))
# score_file.close()

# score_file = open("score.txt", "r", encoding="utf8")
#* 줄별로 읽기, 한 줄 읽고 커서는 다음 줄로 이동
# print(score_file.readline(), end=" ")
# print(score_file.readline(), end=" ")
# print(score_file.readline(), end=" ")
# print(score_file.readline(), end=" ")
# score_file.close()

# score_file = open("score.txt", "r", encoding="utf8")
# while True:
#     line = score_file.readline()
#     if not line:
#         break
#     print(line, end="")
# score_file.close()

# score_file = open("score.txt", "r", encoding="utf8")
# lines = score_file.readlines()
# for line in lines:
#     print(line, end="")
# score_file.close()


#! pickle
#* 파일 쓰기
# import pickle
# profile_file = open("profile.pickle", "wb")
# profile = {"이름":"박명수", "나이":30, "취미":["축구", "골프", "코딩"]}
# print(profile)
# pickle.dump(profile, profile_file)
# profile_file.close()

#* 파일 읽기
# profile_file = open("profile.pickle", "rb")
# profile = pickle.load(profile_file)
# print(profile)
# profile_file.close()

#! With
# import pickle
#* 열었던 파일에 대해 따로 close()를 해줄필요없이 자동으로 with문을 탈출하면서 자동으로 닫힘.
# with open("profile.pickle", "rb") as profile_file:
    # print(pickle.load(profile_file))

# with open("study.txt", "w", encoding="utf8") as study_file:
#     study_file.write("파이썬을 열심히 공부하고 있어요.")

with open("study.txt", "r", encoding="utf8") as study_file:
    print(study_file.read())







