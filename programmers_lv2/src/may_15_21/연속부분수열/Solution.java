package may_15_21.연속부분수열;

import java.util.HashSet;

public class Solution{

    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4};
        solution(elements);
    }
    public static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        int sum = 0;
        for(int i = 0; i<elements.length; i++){
            for(int j = 0; j<elements.length;j++){
                sum = elements[j];
                if(i>0){
                    int s = 0;
                    for(int k = 1; k<i+1 ; k++){
                        s= j+k;
                        if(s>elements.length-1)
                            s = s -elements.length;
                        sum+=elements[s];
                    }
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}
