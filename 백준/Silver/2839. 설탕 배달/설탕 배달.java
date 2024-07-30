import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main{

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int y;
    int minSum = 5000;

    for(int x = 0 ; x <= N/3 ; x++){
        if((N - 3 * x) % 5 == 0){
            y = (N - 3 * x) / 5;
            int currentSum = x + y;
            minSum = Math.min(minSum, currentSum);
        }
    }
    if(minSum == 5000){
        minSum = -1;
    }

    bw.write(minSum + "\n");

    bw.flush();
    bw.close();
    br.close();
    }
}