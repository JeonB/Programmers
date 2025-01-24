function solution(s) {
    let answer = 0;

    function isCorrect(str) {
        const stack = [];
        for (const char of str) {
            if (char === '(' || char === '{' || char === '[') {
                stack.push(char);
            } else {
                if (stack.length === 0) return false; 
                const last = stack.pop();
                if (
                    (char === ')' && last !== '(') ||
                    (char === '}' && last !== '{') ||
                    (char === ']' && last !== '[')
                ) {
                    return false; 
                }
            }
        }
        return stack.length === 0; 
    }

    for (let i = 0; i < s.length; i++) {
        if (isCorrect(s)) answer++;
        s = s.slice(1) + s[0]; 
    }

    return answer;
}
