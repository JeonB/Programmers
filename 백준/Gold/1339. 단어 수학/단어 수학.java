import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // 각 앒파벳의 가중치를 계산한다.
        Map<Character, Integer> weightMap = new HashMap<>();
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                weightMap.put(c, weightMap.getOrDefault(c, 0) + (int) Math.pow(10, length - i - 1));
            }
        }

        // 알파벳에 가중치를 부여한다.
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(weightMap.entrySet());

        int num = 9;
        Map<Character, Integer> charToNum = new HashMap<>();
        while (!pq.isEmpty()) {
            charToNum.put(pq.poll().getKey(), num--);
        }

        // 가중치 합 구하기
        int totalSum = 0;
        for (String word : words) {
            int wordValue = 0;
            for (char c : word.toCharArray()) {
                wordValue = wordValue * 10 + charToNum.get(c);
            }
            totalSum += wordValue;
        }

        bw.write(totalSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}