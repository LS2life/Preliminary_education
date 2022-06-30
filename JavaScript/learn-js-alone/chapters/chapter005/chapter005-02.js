console.log("Chpater005-02")
/* 
    콜백 함수
    1. 비동기 순서를 동기적으로
    2. 라이브러리(모듈)를 쉽게 활용하기
    callback
    함수->객체
*/
const noNamefunc=function(){
    console.log("익명 함수")
}

function callThreeTimes(callback){
    for(let i=0;i<3;i++){
        callback(i)
    }
}
function print(i){
    console.log(`${i}번째 함수 호출`)
}
callThreeTimes(print)

//익명 함수 사용해서 콜백 함수 
callThreeTimes(function(i){
    const fruits=["사과","바나나","망고"]
    console.log(fruits[i])
})

//화살표 함수==람다
callThreeTimes((i)=>{
    console.log("화살표 함수")
    const fruits=["사과","바나나","망고"]
    console.log(fruits[i])
})
callThreeTimes(i=>{
    console.log("화살표 함수2")
    const fruits=["사과","바나나","망고"]
    console.log(fruits[i])
})

let numbers=[273,52,103,32,57]
numbers.forEach(function(){
    
})
numbers.forEach((value,index,array)=>{
    console.log("value: "+value)
    console.log("index: "+index)
    console.log("array: ")
    console.log(array)
})
//제곱해서 새로운 배열
numbers=numbers.map((value,index,array)=>{
    return value*value
})
numbers=numbers.map((value)=>{
    return value*value
})

console.log(numbers)
numbers.forEach(console.log)

numbers=[0,1,2,3,4,5]
//filter 리턴 값의 true값만 모아서 새로운 배열 생성
const evenNumbers=numbers.filter((value)=>{
    return value%2===0
})

console.log(evenNumbers)

numbers=[0,1,2,3,4,5,6,7,8,9]

numbers
    .filter((value)=>{
        value%2===0
    })
    .map((value)=>{
        value*value
    })
    .forEach(value=>{
        console.log(value)
    })

/* 
    타이머 함수
    setTimeout(함수,시간) -특정 시간 후에 한번 호출
    clearTimeout(타이머_ID) -멈춤
    setInterval(함수,시간) - 특정 시간마다 함수를 호출
    clearInterval(타이머_ID) - 멈춤
*/
//밀리초: 1초==1000밀리초
setTimeout(()=>{
    console.log("setTimeout 실행됨")
},2000)

let count=0
let id=setInterval(()=>{
    console.log(`1초마다 실행됩니다(${count++}번째)`)
},1000)
console.log("id: "+id)

setTimeout(()=>{
    console.log("인터발 함수 멈춤")
    clearInterval(id)
},5000)

let result=(function(){
    console.log("즉시 호출 함수")
})()

// let pi=3.14
// console.log(`파이 값은 ${pi}입니다`)

