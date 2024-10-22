import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int people = Integer.parseInt(br.readLine());
        String seats = br.readLine();
        if (seats.length() < people) {
            System.out.println("인구수 맞추셈");
            return;
        }

        seats = seats.replaceAll("LL", "L");
        if (seats.length() + 1 > people)
            bw.write(people + "\n");
        else
            bw.write((seats.length() + 1) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
