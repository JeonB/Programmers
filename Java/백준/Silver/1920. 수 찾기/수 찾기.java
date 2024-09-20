import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int num : nums){
            bw.write(binarySearch(arr,num,0,N-1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int[] arr, int target,int start, int end) {
        while(start <= end) {
            int mid = (start + end )/ 2;
            if(target == arr[mid]) {
                return 1;
            }else if(target < arr[mid]) {
                end = mid - 1;
            }else if(target > arr[mid]) {
                start = mid + 1;
            }
        }
        return 0;
    }
}
