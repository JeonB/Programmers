function solution(distance, rocks, n) {
    // 바위들을 정렬하여 거리 계산을 용이하게 합니다.
    rocks.sort((a, b) => a - b);
    rocks.push(distance); // 도착 지점을 마지막 바위로 추가합니다.

    let left = 0;
    let right = distance;
    let answer = 0;

    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        let prev = 0;
        let removed = 0;
        let minDistance = Infinity;

        for (let rock of rocks) {
            const currentDistance = rock - prev;

            if (currentDistance < mid) {
                // 최소 거리(mid)를 유지할 수 없으면 바위를 제거합니다.
                removed++;
            } else {
                // 최소 거리를 유지할 수 있으면 prev를 갱신합니다.
                prev = rock;
                minDistance = Math.min(minDistance, currentDistance);
            }
        }

        if (removed > n) {
            // 제거된 바위 수가 너무 많으면 거리를 줄입니다.
            right = mid - 1;
        } else {
            // 최소 거리(mid)를 유지할 수 있으면 정답을 갱신하고 범위를 넓힙니다.
            answer = Math.max(answer, minDistance);
            left = mid + 1;
        }
    }

    return answer;
}
