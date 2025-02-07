function solution(jobs) {
    jobs.sort((a,b) => a[0] - b[0])
    
    const pq = []
    let currentTime = 0
    let totalTaskTime = 0
    let jobIdx= 0
    let completedjob = 0
    
    while(completedjob < jobs.length){
        
        while(jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime){
            const [s,i] = jobs[jobIdx]
            pq.push(jobs[jobIdx])
            pq.sort((a,b) => a[1] - b[1] || a[0] - b[0])
            jobIdx++
        }
        
        if(pq.length > 0){
            const [s,i] = pq.shift()
            currentTime += i
            totalTaskTime += currentTime - s
            completedjob++
        }else{
            currentTime = jobs[jobIdx][0]
        }
    }
    
    return Math.floor(totalTaskTime/completedjob)
}