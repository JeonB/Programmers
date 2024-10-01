import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Node {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph;
    static int[] dist;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (currentWeight > dist[currentVertex]) {
                continue;
            }

            for (Node neighbor : graph.get(currentVertex)) {
                int nextVertex = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[nextVertex] > dist[currentVertex] + weight) {
                    dist[nextVertex] = dist[currentVertex] + weight;
                    pq.offer(new Node(nextVertex, dist[nextVertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());  // 정점의 개수
        int E = Integer.parseInt(st.nextToken());  // 간선의 개수
        int start = Integer.parseInt(br.readLine());  // 시작 정점

        // 그래프 초기화
        graph = new ArrayList<>();
        dist = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            dist[i] = INF;  // 거리 배열을 무한대로 초기화
        }

        // 간선 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));  // u에서 v로 가는 가중치 w인 간선
        }

        // 다익스트라 알고리즘 실행
        dijkstra(start);

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

       
        bw.flush();
        bw.close();
        br.close();
    }
}
