class Solution {
   public int solution(String name) {
        int answer = 0;
        int len = name.length();

        // 알파벳 조작 횟수 계산
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1); // 위/아래 조작 횟수 중 최소값
        }

        // 커서 이동 최소 횟수 계산
        int minMove = len - 1; // 오른쪽으로만 쭉 가는 경우
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            // A가 연속되는 구간을 찾는다.
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            // 오른쪽으로 갔다가 왼쪽으로 돌아오는 경우, 혹은 왼쪽으로 먼저 가는 경우
            minMove = Math.min(minMove, i + len - next + Math.min(i, len - next));
        }
        
        answer += minMove;
        return answer;
    }
}