import java.io.*;
import java.util.*;

public class Main {

    // 도시를 표현할 클래스
    static class Edge {
        int node;
        long cost;

        Edge(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫째 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 도시의 개수
        int m = Integer.parseInt(st.nextToken());  // 도로의 개수
        int k = Integer.parseInt(st.nextToken());  // k번째 최단 경로

        // 인접 리스트를 사용한 그래프 표현
        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // m개의 도로 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }

        // 각 도시로 가는 k번째 최단 경로를 저장하는 리스트
        PriorityQueue<Long>[] dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());  // 최대 힙
        }

        // 우선순위 큐를 사용한 다익스트라 알고리즘
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
        pq.add(new Edge(1, 0));
        dist[1].add(0L);

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.node;
            long nowCost = current.cost;

            // 현재 도시에서 갈 수 있는 모든 도로에 대해 경로 계산
            for (Edge next : graph[now]) {
                long newCost = nowCost + next.cost;

                // next.node로 가는 경로 중 k번째 최단 경로를 업데이트
                if (dist[next.node].size() < k) {
                    dist[next.node].add(newCost);
                    pq.add(new Edge(next.node, newCost));
                } else if (dist[next.node].peek() > newCost) {
                    dist[next.node].poll();
                    dist[next.node].add(newCost);
                    pq.add(new Edge(next.node, newCost));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() == k) {
                bw.write(dist[i].peek() + "\n");
            } else {
                bw.write("-1\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
