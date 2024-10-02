import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int city;
        int time;

        public Node(int city, int time) {
            this.city = city;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시의 수
        int m = Integer.parseInt(st.nextToken()); // 도로의 수
        int k = Integer.parseInt(st.nextToken()); // k번째 최단경로

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 도로 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
        }

        // 각 도시까지의 k번째 최단 경로 시간을 저장하는 우선순위 큐 배열
        PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = new PriorityQueue<>(k, Collections.reverseOrder()); // 최대 k개의 경로를 저장하며 내림차순 정렬
        }

        // 다익스트라 알고리즘 시작 (람다식을 사용한 노드 비교)
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        pq.add(new Node(1, 0)); // 시작 도시는 1번

        dist[1].add(0); // 시작 도시는 소요시간 0

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentTime = current.time;

            // 현재 도시에서 연결된 다른 도시로의 경로 계산
            for (Node next : graph[currentCity]) {
                int nextCity = next.city;
                int nextTime = currentTime + next.time;

                // dist[nextCity]에 저장된 최단경로 중 k번째보다 작은 경로가 있으면 추가
                if (dist[nextCity].size() < k) {
                    dist[nextCity].add(nextTime);
                    pq.add(new Node(nextCity, nextTime));
                } else if (dist[nextCity].peek() > nextTime) {
                    dist[nextCity].poll();
                    dist[nextCity].add(nextTime);
                    pq.add(new Node(nextCity, nextTime));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() == k) {
                bw.write(dist[i].peek() + "\n"); // k번째 최단경로 출력
            } else {
                bw.write("-1\n"); // k번째 최단경로가 존재하지 않으면 -1 출력
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
