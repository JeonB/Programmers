function solution(dots) {
    // 두 점 사이의 기울기를 계산하는 함수
    const calculateSlope = (dot1, dot2) => {
        const [x1, y1] = dot1;
        const [x2, y2] = dot2;
        return (y2 - y1) / (x2 - x1);
    };

    // 네 점에서 두 점을 선택하는 모든 조합 생성
    const pairs = [
        [0, 1, 2, 3],
        [0, 2, 1, 3],
        [0, 3, 1, 2]
    ];

    // 각 조합에 대해 기울기 비교
    for (const [a, b, c, d] of pairs) {
        const slope1 = calculateSlope(dots[a], dots[b]);
        const slope2 = calculateSlope(dots[c], dots[d]);

        // 기울기가 같다면 평행
        if (slope1 === slope2) {
            return 1;
        }
    }

    // 평행한 직선이 없으면 0 반환
    return 0;
}