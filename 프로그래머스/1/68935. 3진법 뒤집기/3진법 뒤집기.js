function solution(n) {
    let answer = '';
    let samginbub = n.toString(3)
   
    for(let i  = samginbub.length - 1 ; i>-1 ; i--){
        answer += samginbub.charAt(i)
    }
    
    answer = parseInt(answer,3)
    return answer;
}