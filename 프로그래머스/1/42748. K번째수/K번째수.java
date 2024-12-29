import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        int i = 0;
        for(int[] command : commands){
            answer[i++] = sortByCommand(array,command);
        }
        return answer;
    }
    
    private int sortByCommand(int[] array, int[] command){
        int[] sortArr = new int[command[1] - command[0] + 1];
        int j = 0;
        for(int i = command[0] ; i < command[1] + 1 ; i++){
            sortArr[j++] = array[i - 1];
        }
        Arrays.sort(sortArr);
        // sortArr.sort();
        return sortArr[command[2] - 1];
    }
}