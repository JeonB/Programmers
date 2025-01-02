function solution(numbers) {
    let answer = '';
    const num = numbers.map(number=>number.toString()).sort((a,b) => (b + a )- (a+b) )
    answer = num.join('')
    
    return answer.startsWith('0') ? '0' : answer;
}