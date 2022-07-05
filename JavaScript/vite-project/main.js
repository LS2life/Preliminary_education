
const todos =['우유 구매', '업무 메일 확인하기', '필라테스 수업']
for (const todo of todos) { 
console.log(`오늘의 할 일: ${todo}`)
}

console.log(2**2)
console.log(2**32)
Number.prototype.power=function(n){
	return this.valueOf()**n
}
