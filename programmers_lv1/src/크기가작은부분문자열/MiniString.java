package 크기가작은부분문자열;

public class MiniString {
    public static void main(String[] args) {
        System.out.println(solution("50022083987242251521251251512512512515242424242242428","725252525252"));
    }
    public static int solution(String t, String p) {
        int answer = 0;
        char[] word = new char[p.length()];
        
        for(int i = 0; i<t.length()-p.length()+1;i++){
            t.getChars(i, i+p.length(), word, 0);
            String str = new String(word);
            long intValue1 = Long.parseLong(str);
            long intValue2 = Long.parseLong(p);
            if(intValue1<=intValue2)
                answer++;
        }
        return answer;
    }
}

/* 
 * 숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성
 
 java.lang.NumberFormatException: For input string: "500220839872" <-- int형을 초과하는 숫자를 넣으면 발생하는 예외. long,Long,parseLong을 사용해야만 한다

 사람들이 많이 푼 풀이법 --> getChars가 아닌 substring을 이용한 방법
 class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length()-p.length()+1; i++){
            if (Long.parseLong(t.substring(i,i+p.length())) <= Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }
}

 */
