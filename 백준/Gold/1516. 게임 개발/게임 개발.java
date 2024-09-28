import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] buildTime = new int[N + 1], indegree = new int[N + 1], result = new int[N + 1];
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int prerequisite = Integer.parseInt(st.nextToken());
                if (prerequisite == -1) break;
                graph[prerequisite].add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result[i] = buildTime[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                result[next] = Math.max(result[next], result[current] + buildTime[next]);
                if (--indegree[next] == 0) queue.offer(next);
            }
        }

        for (int i = 1; i <= N; i++) System.out.println(result[i]);
    }
}
