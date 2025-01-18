function solution(my_string) {
    let answer = '';
    const strSet = new Set()
    
    for(const char of my_string){
        if(strSet.has(char)) continue
        strSet.add(char)
        answer += char
    }
    
    return answer;
}