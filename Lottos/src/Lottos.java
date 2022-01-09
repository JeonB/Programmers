
public class Lottos {

    public static void main(String[] args) {

        int[] lottos = { 2, 0, 0, 35, 12, 11 };
        int[] win_nums = { 5, 7, 14, 35, 12, 11 }; // 당첨번호

        solution(lottos, win_nums);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int count1 = 7; // 등수 결정 변수
        int count2 = 0; // 0의 개수
        int max = 0;
        for (int i = 0; i < win_nums.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[j] == win_nums[i]) {
                    count1--;
                }
                // if (Arrays.asList(win_nums).contains(a)) { // 디버거를 돌려 확인해보니 false가 발생
                // count1--;
                // }
            }

        }
        for (int j = 0; j < lottos.length; j++) {
            if (lottos[j] == 0) {
                count2++;
            }
        }

        if (count1 == 7 || count1 == 6) {
            count1 = 6;
        }

        max = count1 - count2;
        System.out.println("당첨 등수는 " + max + "입니다!");

        int[] answer = { max, count1 };
        return answer;
    }
}
