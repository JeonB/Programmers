function solution(arr) {
     const n = (arr.length + 1) / 2; // 숫자의 개수

    // DP 테이블: maxDp[i][j]는 i번째 숫자부터 j번째 숫자까지 연산 결과의 최댓값
    //            minDp[i][j]는 i번째 숫자부터 j번째 숫자까지 연산 결과의 최솟값
    const maxDp = Array.from({ length: n }, () => Array(n).fill(-Infinity));
    const minDp = Array.from({ length: n }, () => Array(n).fill(Infinity));

    // 초기화: 숫자만 있는 경우
    for (let i = 0; i < n; i++) {
        maxDp[i][i] = minDp[i][i] = parseInt(arr[i * 2]);
    }

    // DP 탐색
    for (let len = 1; len < n; len++) { // 구간의 길이
        for (let i = 0; i < n - len; i++) {
            const j = i + len; // 구간 끝
            for (let k = i; k < j; k++) { // 연산자 위치
                const operator = arr[k * 2 + 1];
                if (operator === '+') {
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k + 1][j]);
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k + 1][j]);
                } else if (operator === '-') {
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k + 1][j]);
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k + 1][j]);
                }
            }
        }
    }

    return maxDp[0][n - 1];
}