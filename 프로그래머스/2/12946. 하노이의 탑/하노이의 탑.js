function solution(n) {
    var answer = [];

    function hanoi(n, from, to) {
        if(n === 1) return answer.push([from,to])
        
        hanoi(n-1, from,6-(from+to))
        answer.push([from,to])
        hanoi(n-1, 6-(from+to),to)
    }

    hanoi(n, 1, 3);

    return answer;
}