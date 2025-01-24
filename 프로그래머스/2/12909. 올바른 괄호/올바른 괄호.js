function solution(s){
    const stack = []
    
    for(let i = 0 ; i < s.length ; i++){
        if(s[i] === ')'){
            if(stack.length === 0) return false
            stack.pop()
        } else{
            stack.push(s[i])
        }
    }
    return stack.length === 0 ? true : false
}