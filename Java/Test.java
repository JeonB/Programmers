import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 데이터 개수
        int L = Integer.parseInt(st.nextToken());  // 최솟값 구하는 범위
        Deque<Node> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int current = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast().value > current){
                deque.removeLast();
            }
            deque.addLast(new Node(current, i));
            if(deque.getFirst().index <= i - L){
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }

}
class Node{
    int value;
    int index;
    Node(int value, int index){
        this.value = value;
        this.index = index;
    }
}