function solution(s, n) {
    let answer = '';

    for (let c of s) {
        if (c === ' ') {
            answer += c;
            continue;
        }

        let ascii = c.charCodeAt(0);
        
        // 소문자 처리
        if (ascii >= 'a'.charCodeAt(0) && ascii <= 'z'.charCodeAt(0)) {
            answer += String.fromCharCode((ascii - 'a'.charCodeAt(0) + n) % 26 + 'a'.charCodeAt(0));
        }
        // 대문자 처리
        else if (ascii >= 'A'.charCodeAt(0) && ascii <= 'Z'.charCodeAt(0)) {
            answer += String.fromCharCode((ascii - 'A'.charCodeAt(0) + n) % 26 + 'A'.charCodeAt(0));
        }
    }
    
    return answer;
}
