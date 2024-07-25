import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());



        bw.write((A + B + C+ D+E+F)  * 5 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


}

