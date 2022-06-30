// var fetched=fetch("https://jsonplaceholder1.typicode.com/posts")
// console.log("fetched",fetched)
//패치를 통한 결과가 성공 했을 때
// fetched.then((result)=>{
    //     console.log("result",result)
    // })
    //패치를 통한 결과가 실패 했을 때
    // fetched.catch((reason)=>{
        //     console.log("reason",reason)
        // })

fetch("https://jsonplaceholder.typicode.com/posts")
    .then((response)=>{
        // reponse.text()
        // console.log("reponse",reponse.json())
        // response.json().then((data)=>{
        //     console.log("data",data)
        // })
        return response.json()
    })
    .catch((reason)=>{
        console.log("reason",reason)
    })
    .then((data)=>{
        console.log("data",data)
    })