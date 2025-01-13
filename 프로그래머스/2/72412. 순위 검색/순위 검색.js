function solution(info, query) {
    const db = {};

    // 모든 조합을 생성하고 점수를 저장
    function combination(array, score, start) {
        const key = array.join('');
        if (!db[key]) db[key] = [];
        db[key].push(score);

        for (let i = start; i < array.length; i++) {
            const temp = [...array];
            temp[i] = '-';
            combination(temp, score, i + 1);
        }
    }

    // info를 기반으로 사전 처리
    info.forEach(entry => {
        const [lang, job, career, food, score] = entry.split(' ');
        combination([lang, job, career, food], parseInt(score), 0);
    });

    // 점수 목록 정렬
    for (const key in db) {
        db[key].sort((a, b) => a - b);
    }

    // 이진 탐색 함수
    function binarySearch(scores, target) {
        let left = 0, right = scores.length;
        while (left < right) {
            const mid = Math.floor((left + right) / 2);
            if (scores[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return scores.length - left;
    }

    // 쿼리 처리
    return query.map(q => {
        const [condition, targetScore] = q.replace(/ and /g, '').split(' ');
        const key = condition;
        const score = parseInt(targetScore);

        if (!db[key]) return 0;
        return binarySearch(db[key], score);
    });
}
