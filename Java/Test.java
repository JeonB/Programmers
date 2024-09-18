import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Test {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 노드 개수
        int M = Integer.parseInt(st.nextToken());  // 간선 개수
        int V = Integer.parseInt(st.nextToken());  // 시작 노드
        visited = new boolean[N+1];
        list = new ArrayList<>();

        for(int i =0 ; i<=N ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);
        System.out.println();
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start){
        if(visited[start]){
            return;
        }
        Collections.sort(list.get(start));
        visited[start] = true;
        System.out.print(start + " ");
        for(int i : list.get(start)){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    static void bfs(int start){
        if (!visited[start]){
            System.out.print(start + " ");
        }
        visited[start] = true;
        Collections.sort(list.get(start));
        ArrayList<Integer> queue = new ArrayList<>();
        for(int i : list.get(start)){
            if(!visited[i]){
                System.out.print(i + " ");
                visited[i] = true;
                queue.add(i);
            }
        }
        for(int i : queue){
            bfs(i);
        }
    }
}
