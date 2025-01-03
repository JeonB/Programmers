import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            isPrime(i);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void isPrime(int n) {
        if (n == 1)
            return;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return;
            }
        }
        System.out.println(n);
    }
}
