public class Soultion {

  public static void main(String[] args) throws Exception {
    int[] num = { 3, 3, 3, 2, 2, 2 };
    System.out.println(solution(num));
  }

  public static int solution(int[] nums) {
    int answer = 0;
    int max = nums.length / 2;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) continue;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) nums[j] = 0;
      }
      answer++;
    }

    if (max > answer) return answer; else return max;
  }
}
//프로그래머스 모범 답안, 리스트로 중복된 값 삭제
/* 
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        //1. 기존 length를 구한다.
        //2. 중복값을 제거한 length를 구한다.
        //3. 두 값중 최소값이 정답.
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return nums.length/2 > list.size()?list.size():nums.length/2;
    }
}
 */
