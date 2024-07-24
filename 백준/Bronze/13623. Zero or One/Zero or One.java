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

        if( A == B && B == C) bw.write('*');
        else if( B == C) bw.write('A');
        else if( A == C) bw.write('B');
        else if( A == B) bw.write('C');



        bw.flush();
        bw.close();
        br.close();
    }

 }

