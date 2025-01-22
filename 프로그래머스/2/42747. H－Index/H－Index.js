function solution(citations) {
    let h = 0
    const n = citations.length
    citations.sort((a,b) => a-b)
    
    for(let i = 0 ; i < n ; i++){
        for(let standard = 0 ; standard < 10001 ; standard++){
            if(citations[i] >= standard && n-i >= standard ){
                h = Math.max(h,standard)
            }else{
                break
            }
           
        }
    }
    
    return h
}