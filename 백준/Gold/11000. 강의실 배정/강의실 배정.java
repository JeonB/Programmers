import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] lectures = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 시간을 기준으로 정렬
        Arrays.sort(lectures, (a, b) -> Integer.compare(a[0], b[0]));

        // 종료 시간을 관리하는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(lectures[0][1]);

        for (int i = 1; i < n; i++) {
            // 현재 수업의 시작 시간과 비교하여 가장 빨리 끝나는 수업과 비교
            if (lectures[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(lectures[i][1]);
        }

        // pq에 남아있는 원소 개수가 필요한 강의실의 수
        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
