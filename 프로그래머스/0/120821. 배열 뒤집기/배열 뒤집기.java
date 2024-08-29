class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = num_list;
        for(int i = 0 ; i<answer.length/2; i++){
            int temp = answer[answer.length - 1 - i];
            answer[answer.length - 1 - i] = answer[i];
            answer[i] = temp;
        }
        return answer;
    }
}