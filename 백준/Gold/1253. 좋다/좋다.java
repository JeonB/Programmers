import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];
    int answer = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i<N ;i++){
        nums[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nums);

    for(int k = 0; k<N ; k++){
     int i = 0;
     int j = N-1;
     int target = nums[k];
      while(i<j){
          if(i == k){
              i++;
              continue;
          }
          if(j == k){
              j--;
              continue;
          }
          int sum = nums[i] + nums[j];
          if(sum == target){
              answer++;
              break;
          }else if(sum < target){
              i++;
          }else{
              j--;
          }
      }
    }

    bw.write(answer + "\n");

    bw.flush();
    bw.close();
    br.close();
    }
}
