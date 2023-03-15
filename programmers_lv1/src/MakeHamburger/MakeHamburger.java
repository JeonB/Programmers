package MakeHamburger;

import java.util.*;

public class MakeHamburger {


  public int solution(int[] ingredient) {
    int answer = 0;
    ArrayList<Integer> ingredient_list = new ArrayList<>();
    ArrayList<Integer> burger = new ArrayList<>();
    burger.add(1);
    burger.add(2);
    burger.add(3);
    burger.add(1);

    for(int i = 0 ; i<ingredient.length;i++){
      ingredient_list.add(ingredient[i]);
      if(ingredient_list.size() > 3){
        ArrayList<Integer> temp_list = new ArrayList<>();
        temp_list.add(ingredient_list.get(ingredient_list.size()-4));
        temp_list.add(ingredient_list.get(ingredient_list.size()-3));
        temp_list.add(ingredient_list.get(ingredient_list.size()-2));
        temp_list.add(ingredient_list.get(ingredient_list.size()-1));
          if(temp_list.equals(burger)){
            answer++;
            for(int j = 0 ; j<4;j++)
              ingredient_list.remove(ingredient_list.size()-1);
          }
      }
    }
    return answer;
  }
}


/* 모범답안
class Solution {
  public int solution(int[] ingredient) {
      int[] stack = new int[ingredient.length];
      int sp = 0;
      int answer = 0;
      for (int i : ingredient) {
          stack[sp++] = i;
          if (sp >= 4 && stack[sp - 1] == 1
              && stack[sp - 2] == 3
              && stack[sp - 3] == 2
              && stack[sp - 4] == 1) {
              sp -= 4;
              answer++;
          }
      }
      return answer;
  }
} 
*/