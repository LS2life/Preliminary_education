console.log("Chapter005")

/* 익명 함수 */
const 함수=function(){
    console.log("함수 내부의 코드 1")
    console.log("함수 내부의 코드 2")
    console.log("함수 내부의 코드 3")
    console.log("함수 내부의 코드 4")
}

함수()

/* 선언적 함수 */
function funcName(){
    console.log("선언적 함수1")
    console.log("선언적 함수2")
    console.log("선언적 함수3")
}
//함수 호출 (func call)
funcName()

const func1=function(){
    console.log("익명 함수 1")
    console.log("익명 함수 2")
    console.log("익명 함수 3")
}

func1()

// 즉시 호출 함수 IIFE(이피)
// (function() {
//     console.log("func2 called")
// })();

console.log(typeof(func1))

function f(x){
    return x*x
}
console.log(f(2))//4
console.log(f(3))
console.log(f(4))
console.log(f("문자"))//NaN
console.log(2*2)
console.log(3*3)
console.log(4*4)

/* 
    윤년 - 2월 29까지 있는 달
    4년마다 한번씩 옴 - y%4===0 윤년임
    100년마다 윤년이 아님 - y%100===0 윤년아님
    400년마다 윤년임 y%400===0 윤년임
*/

function isLeapYear(year){
    return (year%4===0)&&(year%100!==0)||(year%400===0)
}

if(isLeapYear(2022)){
    console.log("2월 29일까지")
}else{
    console.log("2월 28일까지")
}

console.log(`2023? ${isLeapYear(2023)}`)
console.log(`2024? ${isLeapYear(2024)}`)

/* 
    자바-
    같은 이름의 함수 정의 가능
    단, 매개변수의 개수, 매개변수의 타입이 다를때
    -메소드 오버로딩
*/
/* 
    ...variableName->나머지 매개변수
*/
function f1(...items){
    console.log(items)
    for(const item of items){
        console.log(item)
    }
}
f1(1)
f1(1,2)
f1(1,2,3)
f1(1,2,3,4)

//최솟값 구하기
function min(...numbers){
    let num=numbers[0]
    for(const number of numbers){
        if(num>number){
            num=number
        }
    }
    return num
}

console.log("최솟값 찾기: "+min(12,35,8789,3454,79,6,78,2345))
/* 
    전개 연산자
    배열을 전개 한다
*/
const array=[1,2,3,4]
console.log(`${array[0]},${array[1]}`)
console.log()
console.log(min(...array))
console.log(min(1,2,3,4))

//시급 계산기

function earnings(name,wage=9160,hours=40){
    console.log(`# ${name}님의 급여 정보`)
    console.log(`- 시급 ${wage}원`)
    console.log(`- 근무시간 ${hours}시간`)
    console.log(`- 급여: ${wage*hours}원`)
}

earnings("김ECMA",9160,8)
earnings("김ECMA1")
earnings("김ECMA2",10000)
earnings("김ECMA3",15000,15)

let result=(function(){
    return "즉시 호출 함수"
})()
console.log(result)


