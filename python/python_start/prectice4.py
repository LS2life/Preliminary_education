
#! 함수
def open_account():
    print("새로운 계좌가 생성되었습니다.")

#! 전달값과 반환값
def deposit(balance, money):
    print("입금이 완료되었습니다. 잔액은 {0} 원입니다.".format(balance + money))
    return balance + money

# 출금
def withdraw(balance, money):
    # 잔액이 출금보다 많으면
    if balance >= money:
        print("출금이 완료되었습니다. 잔액은 {0} 원입니다.".format(balance - money))
        return balance - money
    else:
        print("출금이 완료되지 않았습니다. 잔액은 {0} 원입니다.".format(balance))
        return balance

# 저녁에 출금
def withdraw_night(balance, money):
    #수수료 100원
    commission = 100
    return commission, balance - money - commission

# 잔액
balance = 0
balance = deposit(balance, 1000)
# balance = withdraw(balance, 2000)
# balance = withdraw(balance, 5000)
commission, balance = withdraw_night(balance, 500)
print("수수료 {0} 원이며, 잔액으 {1} 원입니다.".format(commission, balance))

#! 기본값 설정
def profile(name, age, main_lang):
    print("이름 : {0}\t나이 : {1}\t 주 사용 언어: {2}" \
        .format(name, age, main_lang))

profile("유재석", 20, "파이썬")
profile("김태호", 20, "자바")

#* 같은학교 같은 학년 같은 반 같은 수업.

def profile(name, age=17, main_lang="파이썬"):
    print("이름 : {0}\t나이 : {1}\t 주 사용언어 : {2}") \
        .format(name, age, main_lang)

profile("유재석")
profile("김태호")

#! 키워드값을 이용한 함수 호출
def profile(name, age, main_lang):
    print(name, age, main_lang)
    









