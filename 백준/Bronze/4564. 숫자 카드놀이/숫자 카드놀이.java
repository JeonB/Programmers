import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Main
 */
class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        while (Integer.parseInt(S) != 0) {
            bw.write(S + " ");
            while (S.length() > 1) {
                int result = 1;
                for (int i = 0; i < S.length(); i++) {
                    result *= S.charAt(i) - '0';
                }
                S = Integer.toString(result);
                bw.write(S + " ");
            }
            bw.write("\n");
            S = br.readLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }
}