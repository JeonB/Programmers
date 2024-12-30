function solution(citations) {
    let answer = 0;
    citations.sort((a,b) => a-b)
    const n = citations.length
    
    if(citations[n-1] === 0) return answer
    
    for(let i = 0 ; i < n ; i++){
        const h = n - i
        if(h <= citations[i]) return h
    }
    
    
    
    return answer;
}