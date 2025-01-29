function solution(progresses, speeds) {
    const days = []
    const deploy = []
    let queue = []
    
    for(let i = 0 ; i < speeds.length ; i++){
        const day = Math.ceil((100 - progresses[i]) / speeds[i])
        days.push(day)
    }
    
    for(const day of days){
        
        if(queue.length === 0 ) queue.push(day)
        else{
            if(queue[0] < day){
                deploy.push(queue.length)
                queue = []
            }
             queue.push(day)
        }
      
    }
    if(queue.length > 0) deploy.push(queue.length)
    
    return deploy
}