function solution(n) {
    // 삼각형을 저장할 2차원 배열을 초기화합니다.
    const triangle = Array.from({ length: n }, (_, i) => Array(i + 1).fill(0));
    console.log(triangle)
    let num = 1; // 삼각형에 채울 숫자
    let x = -1, y = 0; // 시작 위치

    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            if (i % 3 === 0) {
                // 아래로 이동
                x++;
            } else if (i % 3 === 1) {
                // 오른쪽으로 이동
                y++;
            } else if (i % 3 === 2) {
                // 위로 이동
                x--;
                y--;
            }
            triangle[x][y] = num++;
        }
    }

    // 2차원 배열을 1차원 배열로 변환하여 반환합니다.
    return triangle.flat();
}


