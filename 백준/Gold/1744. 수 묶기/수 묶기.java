import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                oneCount++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                negative.add(num);
            }
        }

        // 양수는 내림차순으로 정렬
        Collections.sort(positive, Collections.reverseOrder());
        // 음수는 오름차순으로 정렬
        Collections.sort(negative);

        int sum = 0;

        // 양수는 큰 것끼리 곱해줌
        for (int i = 0; i < positive.size() - 1; i += 2) {
            sum += positive.get(i) * positive.get(i + 1);
        }
        // 남는 양수는 더해줌
        if (positive.size() % 2 == 1) {
            sum += positive.get(positive.size() - 1);
        }

        for (int i = 0; i < negative.size() - 1; i += 2) {
            sum += negative.get(i) * negative.get(i + 1);
        }
        if (negative.size() % 2 == 1) {
            if (zeroCount == 0) {
                sum += negative.get(negative.size() - 1);
            }
        }

        sum += oneCount;

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}