
#! 모듈
# import theater_module
# theater_module.price(3)
# theater_module.price_morning(4)
# theater_module.price_soldier(5)

# import theater_module as mv
# mv.price(3)
# mv.price_morning(4)
# mv.price_soldier(6)

# from theater_module import *
# from random import *
# price(randint(0, 10))
# price_morning(randint(0, 10))
# price_soldier(randint(0, 10))

# from theater_module import price, price_morning
# price(5)
# price_morning(3)
# price_so

# from theater_module import price_soldier as ps
# ps(4)

#! 패키지 (모듈이 여러개)
# import travel.thailand
# trip_to = travel.thailand.ThailandPackage()
# trip_to.detail()

# from travel.thailand import ThailandPackage
# trip_to = ThailandPackage()
# trip_to.detail()

# from travel import vietnam
# trip_to = vietnam.VietnamPackage()
# trip_to.detail()

# from travel import *
# # trip_to = vietnam.VietnamPackage()
# trip_to = thailand.ThailandPackage()
# trip_to.detail()

# from travel import *
# import inspect
# import random
# print(inspect.getfile(random))
# print(inspect.getfile(thailand))


#! pip install
# http://pypi.org

# from bs4 import BeautifulSoup
# soup = BeautifulSoup("<p>Some<b>bad<i>HTML")
# print(soup.prettify())

# 설치된 pip 목록
# pip list

# show를 요청한 패키지의 정보
# pip show beautifulsoup4

# 업데이트
# pip install --upgrade beautifulsoup4

# 패키지 제거
# pip uninstall beautifulsoup4


#! 내장함수
# input : 사용자 입력을 받는 함수
# dir : 어떤 객체를 넘겨줬을 때 그 객체가 어떤 변수와 함수를 가지고 있는지 표시

# print(dir())
# import random
# print(dir())
# import pickle
# print(dir())

# lst = [1, 2, 3]
# print(dir(lst))

# name = "Jim"
# print(dir(name))

# list of python builtins 구글 검색
#   내장함수 목록 및 설명

# list of python module 구글 검색
# 외장 모듈 리스트 및 설명

# import glob
# print(glob.glob("*.py"))

#* os : 운영체제에서 제공하는 기본기능
# import os
# print(os.getcwd())

# folder = "./sample_dir"

# if os.path.exists(folder):
#     print("이미 존재하는 폴더입니다.")
#     os.rmdir(folder, "폴더를 삭제하였습니다.")
# else:
#     os.makedirs(folder)
#     print(folder, "폴더를 생성하였습니다.")

# print(os.listdir())

#* 시간관련 함수
# import time
# print(time.localtime())
# print(time.strftime("%Y-%m-%d %h:%M:%S"))

#* 두 날짜 사이의 간격
# import datetime
# print("오늘은 ", datetime.date.today(), " 입니다.")
# today = datetime.date.today()
# td = datetime.timedelta(days=100)
# print("우리가 만나지 100일은 ", today + td)














