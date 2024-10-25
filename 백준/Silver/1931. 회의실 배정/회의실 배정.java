import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 회의 정보를 저장할 배열 선언
        int[][] meetings = new int[n][2];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 끝나는 시간을 기준으로 정렬, 끝나는 시간이 같으면 시작 시간을 기준으로 정렬
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        // 그리디 알고리즘을 통해 최대 회의 개수 찾기
        int count = 0;
        int endTime = 0;

        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                count++;
            }
        }

        // 결과 출력
        bw.flush();
        bw.write(count + "\n");
        bw.close();
    }
}
