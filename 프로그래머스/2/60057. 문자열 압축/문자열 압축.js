function solution(s) {
    let answer = 1000000;
    
    for(let k = 1 ; k<= s.length;k++){
        
        let prev = s.substring(0,k)
        let cnt = 1
        let sb = ''
        for(let i = k ; i<= s.length ; i+=k){
            let current
            if(i+k> s.length) current = s.substring(i)
            else current = s.substring(i,i+k)
            
            if(prev === current){
                cnt++
            }else{
                if(cnt > 1) sb += cnt
                sb+=prev
                prev = current
                cnt = 1
            }
        }
        if(cnt > 1) sb += cnt
        sb += prev
        answer = Math.min(answer , sb.length)
    }
    
    return answer;
}