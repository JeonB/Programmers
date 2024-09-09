import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] nums = new int[N];
    int[] sums = new int[N];
    int[] answer = new int[M];
    st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < N ; i++){
        nums[i] = Integer.parseInt(st.nextToken());
        if(i>0) sums[i] = sums[i-1] + nums[i];
        else sums[i] = nums[i];
    }

    for(int k = 0 ; k < M ; k++){
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        if(i == 1) answer[k] = sums[j-1];
        else answer[k] = sums[j-1] - sums[i-2];
    }

    for(int a : answer){
        bw.write(a + "\n");
    }

    bw.flush();
    bw.close();
    br.close();
    }
}
