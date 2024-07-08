function solution(s) {
    var answer = [];
    s = s.replace(/{/g, '[').replace(/}/g, ']');

    // 문자열을 배열로 변환
    let array = JSON.parse(s);

    // 배열을 각 요소의 길이 순으로 정렬
    array.sort((a, b) => a.length - b.length);
    
    for (let subArray of array) {
        for (let num of subArray) {
            if (!answer.includes(num)) {
                answer.push(num);
    }
  }
}
    return answer;
}