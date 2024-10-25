import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String shake = br.readLine();
        int big = 0;
        int small = 0;

        int[] yabawi = { 1, 0, 0, 4 };

        for (char c : shake.toCharArray()) {
            swap(c, yabawi);
        }
        for (int i = 0; i < yabawi.length; i++) {
            if (yabawi[i] == 4)
                big = i + 1;
            else if (yabawi[i] == 1)
                small = i + 1;
        }
        bw.write(small + "\n" + big);

        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] swap(char c, int[] yabawi) {
        int temp;
        switch (c) {
            case 'A':
                temp = yabawi[0];
                yabawi[0] = yabawi[1];
                yabawi[1] = temp;
                break;
            case 'B':
                temp = yabawi[0];
                yabawi[0] = yabawi[2];
                yabawi[2] = temp;
                break;
            case 'C':
                temp = yabawi[0];
                yabawi[0] = yabawi[3];
                yabawi[3] = temp;
                break;
            case 'D':
                temp = yabawi[1];
                yabawi[1] = yabawi[2];
                yabawi[2] = temp;
                break;
            case 'E':
                temp = yabawi[1];
                yabawi[1] = yabawi[3];
                yabawi[3] = temp;
                break;
            case 'F':
                temp = yabawi[2];
                yabawi[2] = yabawi[3];
                yabawi[3] = temp;
                break;

        }
        return yabawi;
    }
}
