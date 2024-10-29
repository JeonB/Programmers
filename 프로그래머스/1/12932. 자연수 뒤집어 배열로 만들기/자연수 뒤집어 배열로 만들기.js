function solution(n) {
    const answer = [];
    const s = n.toString();
    
    for(let i = 0 ; i < s.length ; i++){
        answer.push(s.charCodeAt(s.length - 1 - i) - 48)
    }
    
    return answer;
}