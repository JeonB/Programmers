import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
        int n = 0;
        for(int[] command : commands){
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] arr = new int[j-i+1];
            for(int m = 0 ; m < arr.length ; m++){
                arr[m] = array[i-1];
                i++;
            }
            Arrays.sort(arr);
            answer[n] = arr[k-1];
            n++;
        }
       
        return answer;
    }
}