import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main{


    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bw.write(recursive(A, B) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static long recursive(int a, int b) {
        if (b == 0) return 1;
        long half = recursive(a, b / 2);
        long result = (half * half) % C;
        if (b % 2 != 0) {
            result = (result * a) % C;
        }
        return result;
    }
}