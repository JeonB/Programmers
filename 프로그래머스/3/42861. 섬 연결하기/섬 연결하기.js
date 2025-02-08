function solution(n, costs) {
    // 비용을 기준으로 오름차순 정렬
    costs.sort((a, b) => a[2] - b[2]);
    
    // Union-Find 자료구조를 위한 배열
    const parent = Array.from({ length: n }, (_, i) => i);
    
    function find(x) {
        if (parent[x] === x) return x;
        return parent[x] = find(parent[x]);
    }
    
    function union(x, y) {
        const rootX = find(x);
        const rootY = find(y);
        if (rootX !== rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
    
    let totalCost = 0;
    let edgesUsed = 0;
    
    for (const [a, b, cost] of costs) {
        if (union(a, b)) { // 사이클이 생기지 않으면 연결
            totalCost += cost;
            edgesUsed++;
            if (edgesUsed === n - 1) break; // 최소 신장 트리가 완성되면 종료
        }
    }
    
    return totalCost;
}