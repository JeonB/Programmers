
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        StringTokenizer st = new StringTokenizer(br.readLine());


        String[] banWords ={"i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"};
        HashMap<String, Boolean> banWordsMap = new HashMap<>();

        // 금지 단어를 HashMap에 추가
        for (String word : banWords) {
            banWordsMap.put(word, true);
        }
        String[] words = br.readLine().split(" ");


        // 2. 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if(banWordsMap.containsKey(words[i]) && i != 0){
                continue;
            }
            sb.append(words[i].charAt(0));
        }
        bw.write(sb.toString().toUpperCase());

        bw.flush();
        bw.close();
        br.close();
    }

    }

