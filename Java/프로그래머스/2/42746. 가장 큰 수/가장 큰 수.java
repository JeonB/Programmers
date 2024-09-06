import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // numbers 배열을 문자열 배열로 변환
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 사용자 정의 정렬: (x + y)와 (y + x)를 비교하여 큰 순서대로 정렬
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // 모든 숫자가 0일 경우 "0"을 리턴
        if (nums[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열을 이어 붙여서 결과 반환
        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }

        return answer.toString();
    }
}
