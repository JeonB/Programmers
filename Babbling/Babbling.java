
package Babbling;
public class Babbling {
    public static void main(String[] args) {
        String[] babbling = {"aayaya", "uuu", "yeye", "yemaye", "ayaayaa"};
        System.out.println(solution(babbling)); 
    }
    public static int solution(String[] babbling) {
        int answer = 0;
        String[] babbling_word = {"ma","ye","woo","aya"};
        for(String word : babbling){
            for(String is_duplicate_word : babbling_word){
                if(!(word.contains(is_duplicate_word.repeat(2)))){
                    word = word.replace(is_duplicate_word, "!");
                }
            }
            if(word.replace("!","") == ""){
                answer++;
            }
    }
        return answer;    
 }
}


/* 모범답안

def solution(babbling):
    count = 0
    babble = [ "aya", "ye", "woo", "ma" ]
    for utter in babbling:
        for text in babble:
            if text * 2 not in utter:
                utter = utter.replace(text, ' ')
        if utter.strip() == '':
            count += 1
    return count

*/