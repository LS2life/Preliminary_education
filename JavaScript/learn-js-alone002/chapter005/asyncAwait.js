//callback hell
function func1(callback){
    callback()
    console.log("작업")
}
function func2(callback){
    callback()
    console.log("작업")
}
function func3(callback){
    callback()
    console.log("작업")
}
func1(()=>{
    console.log("작업")
    func2(()=>{
        console.log("작업")
        func3(()=>{
            console.log("작업")
        })
    })
})

//promise
// setTimeout(()=>{
//     console.log("setTimeout")
//     return this
// },1000)
// .then(()=>{
//     console.log("then")
// })

function timer(time){
    return new Promise(function(resolve){
        setTimeout(function(){
            resolve(time)
        },time)
    })
}
/*
console.log("start")
timer(1000).then(function(time){
    console.log("time:",time)
    return timer(time+1000)
}).then(function(time){
    console.log("time:",time)
    return timer(time+1000)
}).then(function(time){
    console.log("time:",time)
    console.log("end")
})
*/
async function asyncFunc(){
    console.log("start")
    let time=await timer(1000)
    console.log("time:",time)
    time=await timer(time+1000)
    console.log("time:",time)
    time=await timer(time+1000)
    console.log("time:",time)
    console.log("end")
    return time
}

async function asyncFunc2(){
    console.log("parent start")
    // console.log(asyncFunc())
    let time2=await asyncFunc()
    console.log("time2:",time2)
    console.log("parent end")
}
console.log("parent parent start")
asyncFunc2().then(()=>{
    console.log("parent parent end")
})