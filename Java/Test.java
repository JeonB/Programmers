import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class Test {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // 노드 개수
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<N ; j++){
                bw.write("@@@@@");
            }
            bw.write("\n");
        }
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<N ; j++){
                bw.write("@");
            }
            bw.write("\n");
        }
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<N ; j++){
                bw.write("@@@@@");
            }
            bw.write("\n");
        }
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<N ; j++){
                bw.write("@");
            }
            bw.write("\n");
        }
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<N ; j++){
                bw.write("@@@@@");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
