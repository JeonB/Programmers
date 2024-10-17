import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static class Edge {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();
        long[] distance = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            distance[i] = Long.MAX_VALUE;
        }
        distance[1] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(start, end, weight));
        }

        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.start] != Long.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.weight) {
                    distance[edge.end] = distance[edge.start] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (distance[edge.start] != Long.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.weight) {
                bw.write("-1\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (distance[i] == Long.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}