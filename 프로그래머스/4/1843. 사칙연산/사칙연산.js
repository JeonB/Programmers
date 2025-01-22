function solution(arr) {
     const numbers = [];
    const operators = [];
    
    // 주어진 배열을 숫자와 연산자로 분리
    for (let i = 0; i < arr.length; i++) {
        if (i % 2 === 0) {
            numbers.push(parseInt(arr[i]));  // 숫자만 숫자 배열에 추가
        } else {
            operators.push(arr[i]);  // 연산자는 연산자 배열에 추가
        }
    }
    
    const n = numbers.length;
    
    // dp 배열 초기화
    // dp[i][j]는 numbers[i]부터 numbers[j]까지의 구간에 대해 가능한 연산 결과를 저장
    let dpMax = Array.from(Array(n), () => Array(n).fill(null));
    let dpMin = Array.from(Array(n), () => Array(n).fill(null));

    // 각 숫자 하나에 대해 최소값과 최대값은 그 숫자 자체
    for (let i = 0; i < n; i++) {
        dpMax[i][i] = numbers[i];
        dpMin[i][i] = numbers[i];
    }

    // 구간 크기 증가하면서 계산
    for (let len = 2; len <= n; len++) {
        for (let i = 0; i <= n - len; i++) {
            let j = i + len - 1;
            dpMax[i][j] = -Infinity;
            dpMin[i][j] = Infinity;

            // 구간을 나누어 연산 결과를 계산
            for (let k = i; k < j; k++) {
                const operator = operators[k];
                let maxValue, minValue;

                if (operator === '+') {
                    maxValue = dpMax[i][k] + dpMax[k + 1][j];
                    minValue = dpMin[i][k] + dpMin[k + 1][j];
                } else if (operator === '-') {
                    maxValue = dpMax[i][k] - dpMin[k + 1][j];
                    minValue = dpMin[i][k] - dpMax[k + 1][j];
                }

                dpMax[i][j] = Math.max(dpMax[i][j], maxValue);
                dpMin[i][j] = Math.min(dpMin[i][j], minValue);
            }
        }
    }

    // 최종적으로 dpMax[0][n-1]가 최댓값
    return dpMax[0][n-1];
}