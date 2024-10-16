import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static PriorityQueue<Integer>[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }
        distance = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            distance[i] = new PriorityQueue<>(K, (a, b) -> b - a);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.add(new Edge(1, 0));
        distance[1].add(0);
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            for (Edge next : graph.get(cur.v)) {
                if (distance[next.v].size() < K) {
                    distance[next.v].add(cur.w + next.w);
                    pq.add(new Edge(next.v, cur.w + next.w));
                } else if (distance[next.v].peek() > cur.w + next.w) {
                    distance[next.v].poll();
                    distance[next.v].add(cur.w + next.w);
                    pq.add(new Edge(next.v, cur.w + next.w));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i].size() < K) {
                bw.write("-1\n");
            } else {
                bw.write(distance[i].peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}