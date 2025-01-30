function solution(n, results) {
    const win = Array.from({ length: n + 1 }, () => Array(n + 1).fill(false));
    
    // 경기 결과 반영
    results.forEach(([winner, loser]) => {
        win[winner][loser] = true;
    });
    
    // 플로이드-워셜 알고리즘 적용
    for (let k = 1; k <= n; k++) {
        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                if (win[i][k] && win[k][j]) {
                    win[i][j] = true;
                }
            }
        }
    }
    
    // 순위를 확정할 수 있는 선수 찾기
    let count = 0;
    for (let i = 1; i <= n; i++) {
        let knownResults = 0;
        for (let j = 1; j <= n; j++) {
            if (win[i][j] || win[j][i]) {
                knownResults++;
            }
        }
        if (knownResults === n - 1) count++;
    }
    
    return count;
}