import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());

        int sum = 0;
        int answer = 0;
        int[] queueArr = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < cnt; i++){
            queueArr[i] = Integer.parseInt(st.nextToken());
            pq.offer(queueArr[i]);
        }
        while(pq.size() > 0){
            sum += pq.poll();
            answer += sum;
        }


        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}