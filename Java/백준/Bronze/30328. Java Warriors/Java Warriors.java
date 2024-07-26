import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int charge = Integer.parseInt(br.readLine());
        int fee = 4000;


        bw.write(fee *charge + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

 }

