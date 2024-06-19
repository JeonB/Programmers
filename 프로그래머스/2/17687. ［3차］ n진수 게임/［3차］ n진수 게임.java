class Solution {
    public String solution(int n, int t, int m, int p) {
       StringBuilder answer = new StringBuilder();
        StringBuilder sequence = new StringBuilder();
        int num = 0;

        // 숫자를 진법에 맞춰 문자열로 변환하여 sequence에 추가
        while (sequence.length() < t * m) {
            sequence.append(Integer.toString(num, n).toUpperCase());
            num++;
        }

        // 튜브가 말해야 하는 숫자들 추출
        for (int i = 0; i < t; i++) {
            answer.append(sequence.charAt(i * m + (p - 1)));
        }

        return answer.toString();
    }
}