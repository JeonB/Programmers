import java.util.*;

class Solution {
    static int answer = 0;
    static StringBuilder sb;
    public int solution(String word) {
        
        char[] alpha = new char[]{'A','E','I','O','U'};
        
        for(int i = 0 ; i < alpha.length ; i++){
            int index = 0;
            sb = new StringBuilder();
            if(isEqual(alpha[i],word,index)) return answer;
    
            for(int j = 0 ; j < alpha.length ; j++){
                index = 1;
                if(isEqual(alpha[j],word,index)) return answer;
                
                for(int k = 0 ; k < alpha.length ; k++){
                    index = 2;
                    if(isEqual(alpha[k],word,index)) return answer;
                
                    for(int l = 0 ; l < alpha.length ; l++){
                        index = 3;
                        if(isEqual(alpha[l],word,index)) return answer;
                
                        for(int m = 0 ; m < alpha.length ; m++){
                            index = 4;
                            if(isEqual(alpha[m],word,index)) return answer;
        
                        } 
                    }
                }
            }
        }
        
        return answer;
    }
    
    boolean isEqual(char alpha, String word, int index){
        if(sb.length() < index + 1){
            sb.append(alpha);
        }else if(sb.length() == index + 1){
            sb.setCharAt(index, alpha);
        }else{
            sb.setCharAt(index, alpha);
            while(sb.length() > index + 1){
            sb.deleteCharAt(index + 1);
            }
        }
        answer++;
        
        if(word.equals(sb.toString())){
            return true;
        }
        return false;
    }
}