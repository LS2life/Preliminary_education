const f1=()=>{
    setTimeout(()=>{
        for(let i=0;i<3;i++){
            console.log("f1: "+i)
        }
    },100)
}
const f2=()=>{
    for(let i=0;i<3;i++){
        console.log("f2: "+i)
    }
}

// f1()
// f2()

const f3=(callBack)=>{
    setTimeout(()=>{
        for(let i=0;i<3;i++){
            console.log("f3: "+i)
        }
        callBack()
    },100)
}
const f4=()=>{
    for(let i=0;i<3;i++){
        console.log("f4: "+i)
    }
}
// f3(f4)

// async function f5(){
//     f1()
//     // 3초 대기
//     await new Promise((resolve, reject) => setTimeout(resolve, 1000));
//     f2()
// }
// f5()

async function f6(){
    await setTimeout(()=>{
        for(let i=0;i<3;i++){
            console.log("f6: "+i)
        }
    },100)
}
// f6().then(f2())