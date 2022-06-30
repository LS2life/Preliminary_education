console.log("Chapter004")
/* 
for in 반복문 - index 값이 순차적으로 대입
*/
const todos=["우유 구매","업무 메일 확인","필라테스 수업"]
todos.push("자바스크립트 공부")
let todos1=["할일1","할일2"]
// todos=todos1
todos1=todos

for(const i in todos){
    console.log(`${i}번째 할 일: ${todos[i]}`)
}

for(let num in todos){
    console.log(`${num}번째 할 일: ${todos[num]}`)
}

/* 
    for of 반복문 - 값을 순차적 대입
*/

for(const todo of todos){
    console.log(`오늘의 할 일: ${todo}`)
}

for(let i=0;i<5;i++){
    console.log(`${i}번째 반복입니다.`)
}

/* 
    구버젼 자바스크립트
    var
    현재 버젼
    let, const
*/
var num1=0
console.log("num1: ",num1)


for(let i=0;i<todos.length;i++){
    console.log(`${i}번째 할 일: ${todos[i]}`)
}

let i=0
while(i<todos.length){
    console.log(`${i}번째 할 일: ${todos[i]} with while`)
    i++//i=i+1, i+=1
}
//p182

/* 
    break - 중괄호 완전히 종료
    continue- 그 줄에서 실행 멈추고 조건 검사
    return - 함수를 종료
*/

// for(let i=0;true;i++){
//     console.log(i+"번째 반복문입니다")
//     if(i%10==0){
//         const isContinue=confirm("계속 할까요?")
//         if(!isContinue){
//             break;
//         }
//     }
// }
// 터미널 ctl+c 작업 종료

for(let i=0;i<5;i++){
    console.log("continue: "+i)
    continue
    alert("continue: "+i)
}