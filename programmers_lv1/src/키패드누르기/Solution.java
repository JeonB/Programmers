package 키패드누르기;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 10;

        List<Integer> left_digit = Arrays.asList(1, 4, 7,10);
        List<Integer> right_digit = Arrays.asList(3, 6, 9,10);
        List<Integer> mid_digit = Arrays.asList(2,5,8,0);
        StringBuilder sb = new StringBuilder();
        for (int i : numbers) {

            if(left_digit.contains(i)){
                left = i;
                sb.append("L");
            } else if (right_digit.contains(i)) {
                right = i;
                sb.append("R");
            }
            else{
                int left_length = 0;
                int right_length = 0;
                int temp_l = left;
                int temp_r = right;
                int index_l = 0;
                int index_r = 0;

                if(left_digit.contains(left)){
                    if(left == 10)
                        temp_l =0;
                    else
                        temp_l++;
                    left_length++;
                }
                index_l = mid_digit.indexOf(temp_l);
                while (index_l != mid_digit.indexOf(i)){
                    if(index_l>mid_digit.indexOf(i)){
                        index_l--;
                    }
                    else {
                        index_l++;
                    }
                    left_length++;
                }

                if(right_digit.contains(right)){
                    if(right == 10)
                        temp_r = 0;
                    else
                        temp_r--;
                    right_length++;
                }
                index_r = mid_digit.indexOf(temp_r);
                while (index_r != mid_digit.indexOf(i)){
                    if(index_r>mid_digit.indexOf(i)){
                        index_r--;
                    }
                    else {
                        index_r++;
                    }
                    right_length++;
                }

                if(left_length > right_length){
                    right = i;
                    sb.append("R");
                }
                else if (right_length > left_length) {
                    left = i;
                    sb.append("L");
                }
                else {
                    if(hand.equals("right")){
                        right = i;
                        sb.append("R");
                    }
                    else{
                        left = i;
                        sb.append("L");
                    }
                }
            }

        }

        answer = sb.toString();
        return answer;
    }
}
