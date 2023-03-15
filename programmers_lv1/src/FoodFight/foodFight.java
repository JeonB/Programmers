/* 선수들은 1대1 대결
매 대결마다 음식의 종류와 양이 바뀜
한 선수는 왼쪽에서 중앙으로, 다른 선수는 오른쪽에서 중앙으로 먹으면서 이동.
중앙에 있는 물 마시면 승리 

생각나는 해결법???

int food[] --> food[1]부터 끝가지 일단 반으로 나눠서 생각해보자

조건은 각 원소가 1보다 커야 되고 홀수면 거기서 -1

food[1] 이 3이면 3-1 = 2  거기서 다시 2를 나누면 1
즉 1번 음식은 왼쪽에서 1개라는 뜻

이런 식으로 StringBuilder를 사용해서 갖다 붙이면 되지 않을까?
sb1은 왼쪽 sb2는 오른쪽  그리고 중앙값 0을 더한 값 answer를 최종적으로 리턴


*/
package FoodFight;

class Solution {
    public static void main(String[] args) {
        int[] food = {1,7,1,2};
        System.out.println(solution(food));
    }
    public static String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 1 ; i<food.length;i++){
            String food_num = Integer.toString(i);
            if(food[i]>1){
                if(food[i]%2 == 0){
                    food[i] /= 2;
                    for(int j = 0; j<food[i];j++){
                        sb.append(food_num);
                        sb2.append(food_num);
                    }
                }
                else{
                    food[i] -=1;
                    food[i] /= 2;
                    for(int j = 0; j<food[i];j++){
                        sb.append(food_num);
                        sb2.append(food_num);
                    }
                }
            }
        }
        sb2.reverse();
        sb = sb.append("0").append(sb2);
        answer = sb.toString();
        return answer;
    }
}
/* 모범답안
class Solution {
    public String solution(int[] food) {
        String answer = "0";

        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer = i + answer + i; 
            }
        }

        return answer;
    }
} */