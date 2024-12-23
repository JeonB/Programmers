function solution(answers) {
    let answer = [];
    
    person1 = [1,2,3,4,5]
    person2 = [2, 1, 2, 3, 2, 4, 2, 5]
    person3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
   
    let answercnt = [0,0,0]
    for(let i = 0 ; i<answers.length ; i++){
        person1[i%person1.length] === answers[i] ? answercnt[0]++ : null
        person2[i%person2.length] === answers[i] ? answercnt[1]++ : null
        person3[i%person3.length] === answers[i] ? answercnt[2]++ : null
    }

    const maxScore = Math.max(...answercnt);
    console.log(maxScore)
    return answercnt.map((score, index) => ({ index: index + 1, score }))
        .filter(entry => entry.score === maxScore) // 최고 점수만 필터링
        .map(entry => entry.index); // 사람의 번호만 추출
    
}