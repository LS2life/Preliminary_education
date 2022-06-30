console.log("Chapter002")
/* 
    prompt("라벨 메시지","안내 문자열")
 */

// const message=prompt("메세지를 입력 해주세요","여기에 입력 해주세요")
// alert(message)
// console.log(message)

// const b=confirm("수락하시겠습니까?")
// console.log(b)

let a=1
console.log(typeof(a))
a="문자열"
console.log(typeof(a))

let num1=Number("273")
console.log(num1)
console.log(typeof(num1))
/* 
    NaN->Not A Number
*/
let num2=Number("273d")
console.log(num2)
console.log(typeof(num2))

let num3=Number(true)
console.log("true: "+num3)
console.log(typeof(num3))

let num4=Number(false)
console.log("false: "+num4)
console.log(typeof(num4))

/* 연산자 사용해서 자료형 변환 */
//문자로 자동 변환 연산자: +
let data1=1.23+123+""
console.log("data1: "+data1)
console.log(typeof(data1))
let data2=false+""
console.log("data2: "+data2)
console.log(typeof(data2))
// -,*,/,% ->넘버 타잎으로 자동 변환
let data3="52"-0
console.log("data3: "+data3)
console.log(typeof(data3))

console.log(typeof(String(52.273)))

/* 
printf 비슷한 렌더링
*/

let num5=2022
let num6=6
let num7=28

console.log(num5+"년 "+num6+"월 "+num7+"일")
console.log(`${num5}년 ${num6}월 ${num7}일`)

console.log(Boolean(52.273))
console.log(Boolean("sdlfkj"))

/* false로 변환되는 5가지 */
console.log(Boolean(0))
console.log(Boolean(NaN))
console.log(Boolean(""))
console.log(Boolean(null))
let variable
console.log(Boolean(variable))
if(Boolean(variable)){
    console.log("True")
}else{
    console.log("False")
}
console.log(!true)
console.log(!false)
console.log(!!0)
if(!!variable){
    console.log("True")
}else{
    console.log("False")
}

const date=new Date()
console.log(date)
const hour=date.getHours()
console.log(hour)

if(hour<12){
    console.log("오전 입니다")
}
if(hour>12)
console.log("오후 입니다")

if(hour<12){
    console.log("오전 입니다")
}else{
    console.log("오후 입니다")
}

if(hour<12){
    console.log("오전 입니다")
    if(8<hour<9){
        console.log("아침 먹을 시간입니다.")
    }
}else{
    console.log("오후 입니다")
}

if(hour<12){
    console.log("아침 먹을 시간입니다.")
}else if(hour<15){
    console.log("점심 먹을 시간입니다.")
}else if(hour<20){
    console.log("저녁 먹을 시간입니다.")
}else{
    console.log("잘 시간입니다.")
}

// const input=Number(prompt("숫자 입력: "))

// switch(input%2){
//     case 0:
//         console.log("짝수")
//         break
//     case 1:
//         console.log("홀수")
//         break
//     default:
//         console.log("숫자가 아닙니다")
//         break
// }
// const input=Number(prompt("숫자 입력: "))
// const result=input>0?"양수":"음수"
// console.log(result)

let a1=true
let b1=false
console.log(a1||b1)
!a1||console.log("실행 될까요?")
// true && (실행할 문장)

const array=[273,"Sting",true,{1:"Object"},[273,103],function(){}]
console.log(array)

const numbers=[273,52,103,32]
console.log(numbers[0])
console.log(numbers[1])
console.log(numbers[2])
console.log(numbers[3])
let num8=1
console.log(numbers[num8])
console.log(numbers[1+1])

const fruits=["배","사과","키위","바나나","망고"]
console.log(fruits.length)
console.log(fruits[5])
console.log(fruits[fruits.length-2])

fruits[5]="레몬"
console.log(fruits)

fruits[fruits.length]="오렌지"
console.log(fruits)

fruits[0]="참외"
console.log(fruits)

fruits.push("수박")
console.log(fruits)
/* 
    배열.slice(인덱스,제거할 요소의 개수)
*/
const itemsA=["사과",'배',"바나나"]
// itemsA.splice(2,1)
// console.log(itemsA)

// itemsA.splice(1,2)
// console.log(itemsA)

const i=itemsA.indexOf("사과")
console.log(i)
itemsA.splice(i,1)
console.log(itemsA)

const itemsD=["사과","귤","바나나","오렌지"]
itemsD.splice(1,0,"양파")
console.log(itemsD)







