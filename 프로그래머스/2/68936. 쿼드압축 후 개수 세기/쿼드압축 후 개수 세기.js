function solution(arr) {
    function compress(x, y, n) {
        let init = arr[x][y];
        let same = true;

        for (let i = x; i < x + n; i++) {
            for (let j = y; j < y + n; j++) {
                if (arr[i][j] !== init) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            return init === 0 ? [1, 0] : [0, 1];
        }

        let half = n / 2;
        let result1 = compress(x, y, half);
        let result2 = compress(x, y + half, half);
        let result3 = compress(x + half, y, half);
        let result4 = compress(x + half, y + half, half);

        return [
            result1[0] + result2[0] + result3[0] + result4[0],
            result1[1] + result2[1] + result3[1] + result4[1]
        ];
    }

    let n = arr.length;
    return compress(0, 0, n);
}