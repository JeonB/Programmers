function solution(n, times) {
  // 최소 시간과 최대 시간을 정의
  let left = 1;
  let right = Math.max(...times) * n; // 모든 사람이 가장 느린 심사관에게 심사받는 경우
  
  let answer = right;

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    
    // mid 시간 안에 처리할 수 있는 사람 수 계산
    const totalPeople = times.reduce((sum, time) => sum + Math.floor(mid / time), 0);

    if (totalPeople >= n) {
      // 모든 사람을 처리할 수 있으면 시간을 줄여본다
      answer = mid;
      right = mid - 1;
    } else {
      // 처리할 수 있는 사람이 부족하면 시간을 늘려본다
      left = mid + 1;
    }
  }

  return answer;
}
