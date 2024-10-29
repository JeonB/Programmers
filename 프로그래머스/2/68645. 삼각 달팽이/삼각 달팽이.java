import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n+1) / 2];
        int num = 1;
        ArrayList<int[]> triangle = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            triangle.add(new int[i+1]);
        }
        int x = -1 , y = 0;
        for(int i = 0 ; i<n ; i++){
            for(int j = i ; j<n ;j++){
                
                if(i % 3 == 0) x++;
                else if(i % 3 == 1) y++;
                else{
                    x--;
                    y--;
                }
                triangle.get(x)[y] = num++;
            }
        }
        int k = 0;
        for(int[] row : triangle){
            for(int val : row){
                answer[k++] = val;
            }
        }
        
        return answer;
    }
}