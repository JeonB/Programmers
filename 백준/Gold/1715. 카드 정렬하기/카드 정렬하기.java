import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < n ; i++){
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
        }

        int sum =0;

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            sum += a+b;
            pq.add(a+b);
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
