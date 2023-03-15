package CardDummies;

/* 코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다. 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.

원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
한 번 사용한 카드는 다시 사용할 수 없습니다.
카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.
예를 들어 첫 번째 카드 뭉치에 순서대로 ["i", "drink", "water"], 두 번째 카드 뭉치에 순서대로 ["want", "to"]가 적혀있을 때 ["i", "want", "to", "drink", "water"] 순서의 단어 배열을 만들려고 한다면 첫 번째 카드 뭉치에서 "i"를 사용한 후 두 번째 카드 뭉치에서 "want"와 "to"를 사용하고 첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면 원하는 순서의 단어 배열을 만들 수 있습니다.

문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때, cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요. */
import java.util.Arrays;

public class CardDummies {

  public static void main(String[] args) {
    String[] cards1 = { "i", "drink", "water" };
    String[] cards2 = { "want", "to" };
    String[] goal = { "i", "want", "to", "drink", "water" };
    solution(cards1, cards2, goal);
  }

  public static void solution(String[] cards1, String[] cards2, String[] goal) {
    String answer = "";
    int j = 0, k = 0;
    String[] test = new String[goal.length];
    for (int i = 0; i < goal.length; i++) {
      if (goal[i].equals(cards1[j])) {
        test[i] = cards1[j];
        j++;
        // if (j >= cards1.length) {
        //   continue;
        // }
      } else if (goal[i].equals(cards2[k])) {
        test[i] = cards2[k];
        k++;
        // if (k >= cards2.length) {
        //   continue;
        // }
      }
    }
    if (Arrays.equals(goal, test)) {
      answer = "yes";
    } else {
      answer = "no";
    }
    System.out.println(answer);
  }
}
/* 모범답안 - 굳이 문자열 확인 작업 후 마지막에 다시 확인할 필요가 없음을 알려주는 코드
 * 
 * import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cardIdx1 = 0;
        int cardIdx2 = 0;

        for(int i=0; i<goal.length; i++){
            String target = goal[i];

            if(cardIdx1 < cards1.length && target.equals(cards1[cardIdx1]))
                cardIdx1 ++;
            else if (cardIdx2 < cards2.length && target.equals(cards2[cardIdx2]))
                cardIdx2++;
            else
                return "No";
        }


        return "Yes";
    }
}
 */
