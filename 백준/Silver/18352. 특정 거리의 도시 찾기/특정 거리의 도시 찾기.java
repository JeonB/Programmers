import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] visited;
    static ArrayList<Integer> answer;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }
        if (answer.size() == 0) {
            bw.write("-1\n");
        } else {
            answer.sort((a, b) -> a - b);
            for (int i : answer) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node]++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if (visited[next] == -1) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
