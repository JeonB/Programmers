function solution(numbers) {
    return numbers.map((number) => {
        // x의 이진수에서 오른쪽에서 가장 작은 0을 찾고 이를 1로 변경하여 더 큰 수를 만듦
        if (number % 2 === 0) {
            // 짝수의 경우, 바로 다음 수가 답
            return number + 1;
        } else {
            // 홀수의 경우
            let binary = number.toString(2); // 이진수로 변환
            if (!binary.includes('0')) {
                // 모든 비트가 1인 경우, 제일 앞에 10을 추가
                return parseInt('10' + binary.slice(1), 2);
            } else {
                // 오른쪽에서 첫 번째 0을 1로, 바로 다음 비트를 0으로 변경
                let idx = binary.lastIndexOf('0');
                binary = binary.slice(0, idx) + '10' + binary.slice(idx + 2);
                return parseInt(binary, 2);
            }
        }
    });
}