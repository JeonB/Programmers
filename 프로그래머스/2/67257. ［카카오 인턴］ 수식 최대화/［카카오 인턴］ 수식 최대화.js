function solution(expression) {
    const operators = ["+", "-", "*"];
    const priorities = getPermutations(operators);
    let maxResult = 0;

    for (const priority of priorities) {
        const result = evaluateExpression(expression, priority);
        maxResult = Math.max(maxResult, Math.abs(result));
    }

    return maxResult;
}

// 순열 생성 함수
function getPermutations(arr) {
    if (arr.length === 1) return [arr];
    const results = [];
    for (let i = 0; i < arr.length; i++) {
        const rest = [...arr.slice(0, i), ...arr.slice(i + 1)];
        const restPermutations = getPermutations(rest);
        for (const perm of restPermutations) {
            results.push([arr[i], ...perm]);
        }
    }
    return results;
}

// 우선순위에 따라 수식을 평가
function evaluateExpression(expression, priority) {
    let numbers = expression.split(/[^0-9]/).map(Number);
    let operators = expression.match(/[+\-*]/g);

    for (const op of priority) {
        while (operators.includes(op)) {
            const idx = operators.indexOf(op);
            const calcResult = operate(numbers[idx], numbers[idx + 1], op);
            numbers.splice(idx, 2, calcResult);
            operators.splice(idx, 1);
        }
    }

    return numbers[0];
}

// 연산 함수
function operate(a, b, operator) {
    switch (operator) {
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*":
            return a * b;
    }
}
