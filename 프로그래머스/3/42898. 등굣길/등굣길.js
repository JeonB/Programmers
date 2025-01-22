function solution(m, n, puddles) {
    
    const mem = Array.from({length:n+1}, () => Array(m+1).fill(0) )
   
    for(const [x,y] of puddles){
        mem[y][x] = -1
    }

    mem[1][1] = 1    
    
    for(let i = 1 ; i <= n ; i++){
        for(let j = 1 ; j<= m ; j++){
            if(mem[i][j] === -1) {
                mem[i][j] = 0 
                continue
            }
            if(i>1) mem[i][j] += mem[i-1][j]
            if(j>1) mem[i][j] += mem[i][j-1]
            
             mem[i][j] %= 1000000007
        }
    }

    return mem[n][m]
}