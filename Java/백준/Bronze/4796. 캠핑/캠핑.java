
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while(true){
           StringTokenizer st = new StringTokenizer(br.readLine());
           int L = Integer.parseInt(st.nextToken());
           int P = Integer.parseInt(st.nextToken());
           int V = Integer.parseInt(st.nextToken());

           if( V == 0 || L == 0 || P == 0){
               break;
           }

           int answer = (V/P)*L;
           answer += Math.min(V % P, L);

           sb.append("Case " + cnt + ": " + answer + "\n");
           bw.flush();
           cnt++;
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }

}
