import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석의 개수
        int K = Integer.parseInt(st.nextToken()); // 가방의 개수

        // 보석의 무게와 가치를 각각 배열로 분리하여 저장
        int[] weights = new int[N];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // 가방의 용량을 저장할 배열
        int[] backpacks = new int[K];
        for (int i = 0; i < K; i++) {
            backpacks[i] = Integer.parseInt(br.readLine());
        }

        // 1. 보석의 무게 기준으로 정렬 (무게가 같은 경우 가치를 기준으로 정렬)
        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(i -> weights[i]));

        // 2. 가방을 용량 기준으로 정렬
        Arrays.sort(backpacks);

        // 3. 우선순위 큐를 사용하여 가장 비싼 보석부터 선택
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long maxValue = 0;
        int j = 0;

        for (int i = 0; i < K; i++) {
            // 현재 가방에 들어갈 수 있는 모든 보석을 큐에 추가
            while (j < N && weights[indices[j]] <= backpacks[i]) {
                pq.offer(values[indices[j]]);
                j++;
            }
            // 큐에서 가장 비싼 보석을 가방에 넣음
            if (!pq.isEmpty()) {
                maxValue += pq.poll();
            }
        }

        bw.write(maxValue + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
