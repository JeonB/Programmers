import java.util.*;
class Solution {
       public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        // k는 문자열을 나누는 단위
        for (int k = 1; k <= s.length(); k++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            String prev = s.substring(0, k);

            // 문자열을 k 단위로 순회하며 압축
            for (int i = k; i <= s.length(); i += k) {
                String current;

                // 남은 문자열이 k보다 짧을 경우 마지막 부분만 남긴다.
                if (i + k > s.length()) {
                    current = s.substring(i);
                } else {
                    current = s.substring(i, i + k);
                }

                // 이전 문자열과 같으면 count 증가
                if (prev.equals(current)) {
                    count++;
                } else {
                    // 압축 문자열 추가
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = current;
                    count = 1;
                }
            }

            // 마지막으로 남은 문자열 추가
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);

            // 최소 길이 갱신
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}