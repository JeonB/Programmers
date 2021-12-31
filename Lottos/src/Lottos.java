
import java.util.Arrays;
import java.util.stream.IntStream;

public class Lottos {

    public static void main(String[] args) {

        int[] lottos = { 2, 0, 0, 35, 12, 11 };
        int[] win_nums = { 5, 7, 14, 35, 12, 11 };

        solution(lottos, win_nums);
    }

    @SuppressWarnings("unlikely-arg-type")
    public static int[] solution(int[] lottos, int[] win_nums) {
        int count1 = 7; // 등수
        int count2 = 0; // 0의 개수 구하기

        int min = 0, max = 0;
        for (int i = 0; i < win_nums.length; i++) {
            int a = win_nums[i];
            if (Arrays.asList(win_nums).contains(a)) { // 디버거를 돌려 확인해보니 false가 발생
                count1--;
            }
        }
        if (count1 == 7) {
            count1 = 6;
        }
        System.out.println("당첨 등수는 " + count1 + "입니다!");
        min = count1;

        int[] answer = { max, min };
        return answer;
    }

}
