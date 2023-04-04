package 최댓값과최솟값_0404;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        String[] str = s.split("\\s");
        int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).sorted().toArray();

        String answer = nums[0] + " " + nums[nums.length-1 ];
        return answer;
    }
}
