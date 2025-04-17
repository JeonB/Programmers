/**
 * @param {number[]} players 길이 24인 정수 배열. players[i]는 i시~i+1시 이용자 수
 * @param {number} m 한 서버가 감당할 수 있는 최대 이용자 수
 * @param {number} k 한 번 증설된 서버의 운영 시간 (시간 단위)
 * @return {number} 최소 서버 증설 횟수
 */
function solution(players, m, k) {
  const nHours = players.length;      // 24
  const active = Array(nHours).fill(0); // active[i]: i시~i+1시에 가동 중인 추가 서버 수
  let totalExpansions = 0;

  for (let i = 0; i < nHours; i++) {
    const running = active[i];                         // 현재 시간에 이미 가동 중인 서버
    const needed  = Math.floor(players[i] / m);        // 추가로 필요한 서버 수

    if (running < needed) {
      const diff = needed - running;                   // 부족분
      totalExpansions += diff;                         // 증설 횟수 누적

      // i시부터 i+k-1시까지 diff대의 서버가 가동되도록 표시
      const end = Math.min(nHours - 1, i + k - 1);
      for (let j = i; j <= end; j++) {
        active[j] += diff;
      }
    }
  }

  return totalExpansions;
}
