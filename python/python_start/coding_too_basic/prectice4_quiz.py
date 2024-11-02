from random import *

# 1부터 20 까지 숫자를 생성
users = range(1, 21)
# print(type(users))
users = list(users)

print(users)
shuffle(users)
print(users)

winners = sample(users, 4)

print(" - - 당첨자 발표 - - ")
print("치킨 당첨자 : {0}".format(winners[0]))
print("커피 당첨자 : {0}".format(winners[1:]))
print(" - - 축하합니다 - - ")