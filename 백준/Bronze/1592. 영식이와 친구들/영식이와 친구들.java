
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] friends = new int[N];
        int tossCount = 0;
        int idx = 0;

        while(M> friends[idx]){
            friends[idx]++;
            if(friends[idx] == M){
                break;
            }
            tossCount++;
            if(friends[idx] % 2 != 0){
                idx += L;
                if(idx>=N )idx %= N;
            }else{
                idx -= L;
                if( idx<0)idx += N;
            }
        };

        bw.write(tossCount + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    }

