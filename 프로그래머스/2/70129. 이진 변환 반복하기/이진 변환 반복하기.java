class Solution {
    static int deletedZeroCnt = 0;
    
    String conversion(String s){
        int deleteZero = s.replaceAll("0","").length();
        deletedZeroCnt += s.length() - deleteZero;
        String parseIntToBinary = Integer.toString(deleteZero,2);
        return parseIntToBinary;
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        int length = s.length();
        int cnt = 0;
    
        if(s.length() == 1) return answer;

       while(s.length() > 1){
           s = conversion(s);
           cnt++; 
       }
        answer[0] = cnt;
        answer[1] = deletedZeroCnt;
        
        return answer;
    }
}