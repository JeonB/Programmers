import java.math.BigInteger;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        BigInteger answer = N == 0 ? BigInteger.valueOf(1) : facto(1, N);
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static BigInteger facto(int a, int b) {
        if (a == b)
            return BigInteger.valueOf(a);
        int mid = (a + b) / 2;
        return facto(a, mid).multiply(facto(mid + 1, b));
    }

}
