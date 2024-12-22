function solution(n) {
    let answer = [];
    
    function hanoi(n, from , to){
        if(n === 1) return answer.push([from,to])
        
        const empty = 6 - from - to 
        return hanoi(n-1,from, empty) +hanoi(1,from, to)+hanoi(n-1,empty,to)
    }
    
    hanoi(n,1,3)
    return answer;
}