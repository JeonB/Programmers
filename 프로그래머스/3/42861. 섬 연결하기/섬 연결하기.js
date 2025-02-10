function solution(n, costs) {
    costs.sort((a,b) => a[2] - b[2])
    const parent = Array.from({length:n}, (_,i) => i)
    
    function find(x){
        if(x === parent[x]) return x
        return parent[x] = find(parent[x])
    }
    function union(a,b){
        const rootA = find(a)
        const rootB = find(b)
        if(rootA !== rootB){
            parent[rootB] = rootA
            return true
        }
        
        return false
    }
    let totalCost = 0
    let minimalEdge = 0
    for(const [a,b,cost] of costs){
        if(union(a,b)){
            totalCost += cost
            minimalEdge++
            if(minimalEdge === n-1) break
        }
    }
    return totalCost
}