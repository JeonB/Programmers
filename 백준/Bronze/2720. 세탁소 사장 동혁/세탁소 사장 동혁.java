
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        final int QUATER = 25;
        final int DIME = 10;
        final int NICKEL = 5;
        final int PENNY = 1;

        // 1. 입력한 수 N만큼 거스름 돈 입력 및 최소 동전 수 반환 값 저장
        ArrayList<int[]> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int charge = Integer.parseInt(br.readLine());
            int[] charges = new int[4];
            while (charge > 0) {
                if (charge >= QUATER) {
                    charges[0] = charge / QUATER;
                    charge -= QUATER * charges[0];
                } else if (charge >= DIME) {
                    charges[1] = charge / DIME;
                    charge -= DIME * charges[1];
                } else if (charge >= NICKEL) {
                    charges[2] = charge / NICKEL;
                    charge -= NICKEL * charges[2];
                } else {
                    charges[3] = charge / PENNY;
                    charge -= PENNY * charges[3];
                }
            }
            answer.add(charges);
        }

        // 2. 출력
        for (int[] charges : answer) {
            for (int j = 0; j < charges.length; j++) {
                bw.write(charges[j] + (j < charges.length - 1 ? " " : ""));
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
