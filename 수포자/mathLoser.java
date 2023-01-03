package 수포자;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));
    }
    
    public static Integer[] solution(int[] answers) {
        List<Integer> list = new ArrayList<Integer>();
        int topScore = Math.max(answer_1(answers), Math.max(answer_2(answers), answer_3(answers)));
        if(topScore == answer_1(answers))
            list.add(1);
        if(topScore == answer_2(answers))
            list.add(2);
        if(topScore == answer_3(answers))
            list.add(3);
        
        Integer[] answer = list.toArray(new Integer[0]);
            return answer;
    }

    public static int answer_1(int[] answers){
        int cnt = 0;
        int j = 1 ;
        for(int i : answers){
            if(i == j){
                cnt++;
                j++;
            }
            if(j>5)
              j = 1;
            }
            return cnt;
        }
    public static int answer_2(int[] answers){
        int cnt = 0 ;
        int[] answer_2 = {2,1,2,3,2,4,2,5};
        int j = 0 ;
        for(int i : answers){
            if(i == answer_2[j]){
                cnt++;
                j++;
            }   
            if(j>7)
             j=0;
        }
        return cnt;
    }
    public static int answer_3(int[] answers){
        int cnt = 0;
        int[] answer_3 = {3,3,1,1,2,2,4,4,5,5};
        int j = 0;
        for(int i : answers){
            if(i == answer_3[j]){
                cnt++;
                j++;
            }
            if(j>9)
              j=0;
        }
        return cnt;
    }
}

/*  문제 수는 1문제 이상 10000문제 이하
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... 

각각의 수포자가 찍는 방식으로 메소드 작성??
1번 수포자
int j = 1
for  int i : answers
    if(i == j)
        1_answer++
        j++;
        if(j>5)
            j = 1
2번 수포자
int[] j = {2,1,2,3,2,4,2,5}
int k = 0 
for int i : answers
    if(i == j[k])
        
final int[] student1 = {1, 2, 3, 4, 5};
        final int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int studentAnswer1 = 0;
        int studentAnswer2 = 0;
        int studentAnswer3 = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                studentAnswer1++;
            }
            if (answers[i] == student2[i % student2.length]) {
                studentAnswer2++;
            }
            if (answers[i] == student3[i % student3.length]) {
                studentAnswer3++;
            }
        }

        int topScore = Math.max(studentAnswer1, Math.max(studentAnswer2, studentAnswer3));

        if (topScore == studentAnswer1) {
            result.add(1);
        }
        if (topScore == studentAnswer2) {
            result.add(2);
        }
        if (topScore == studentAnswer3) {
            result.add(3);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
*/