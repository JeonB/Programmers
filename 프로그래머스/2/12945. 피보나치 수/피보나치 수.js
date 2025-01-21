function solution(n) {
    
    const mem = new Array(n+1).fill(0)
    mem[1] = 1
    for(let i = 1 ; i < n ; i++){
        mem[i+1] += mem[i] % 1234567
        if(i+2 < mem.length) mem[i+2] += mem[i] % 1234567
    }
    return mem[n] % 1234567;
}