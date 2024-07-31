import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

class Main{


    // static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        // A = Integer.parseInt(st.nextToken());
        // B = Integer.parseInt(st.nextToken());
        // C = Integer.parseInt(st.nextToken());

        bw.write(LocalDate.now().toString());

        bw.flush();
        bw.close();
        br.close();
    }

}