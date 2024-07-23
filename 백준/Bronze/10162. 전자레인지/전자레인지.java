
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());


        // 2. 출력
        if(T%10 > 0 )
            bw.write("-1");
        else{
            bw.write(T/300 + " " + T%300/60 + " " + (T%300%60)/10);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    }

