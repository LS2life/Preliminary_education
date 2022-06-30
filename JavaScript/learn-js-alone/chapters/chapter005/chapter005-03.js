
function mainJS(){
    f1()
    // {
    //     let pi=3.14
    //     console.log(`파이 값은 ${pi}입니다`)
    // }
    function f1(){
        let pi=3.14
        console.log(`파이 값은 ${pi}입니다`)
    }
    let num1=0
    console.log(num1)
    var data=10
    console.log("data: "+data)
    /* 엄격 모드 */
    'use strict'

    function func1(){
        setTimeout(()=>{
            for(let i=0;i<3;i++){
                console.log("func1:"+i)
            }
        },500)
    }
    function func2(){
        for(let i=0;i<3;i++){
            console.log("func2:"+i)
        }
    }
    // func1()
    // func2()

    function func3(callback){
        setTimeout(()=>{
            for(let i=0;i<3;i++){
                console.log("func3:"+i)
            }
            callback()
        },500)
    }

    function func4(){
        for(let i=0;i<3;i++){
            console.log("func4:"+i)
        }
    }
    // func3(func4)

    function timer(time){
        return new Promise((resolve)=>{
            setTimeout(()=>{
                resolve(time)
            },time)
        })
    }
    // console.log("start")
    // timer(1000)
    //     .then((time)=>{
    //         console.log(time/1000,"초 후 실행")
    //         return timer(time+1000)
    //     })
    //     .then((time)=>{
    //         console.log(time/1000,"초 후 실행")
    //         return timer(time+1000)
    //     })
    //     .then((time)=>{
    //         console.log(time/1000,"초 후 실행")
    //         console.log("end")
    //     })
    //async await
    async function asyncFunc(){
        console.log("start")
        let time=await timer(1000)
        console.log(time/1000,"초 후 실행")
        time=await timer(time+1000)
        console.log(time/1000,"초 후 실행")
        time=await timer(time+1000)
        console.log(time/1000,"초 후 실행")
        console.log("end")
    }
    asyncFunc()

    fetch("https://jsonplaceholder.typicode.com/posts")
        .then((response)=>{
            return response.json()
        })
        .then(data=>{
            console.log(data)
        })
}
mainJS()