import java.io.*;
import java.util.*;

class Main {
    static long[] arr;
    static long[] tree;

    // 세그먼트 트리 빌드
    public static long init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = arr[start]; // 리프 노드에 배열 값을 저장
        } else {
            int mid = (start + end) / 2;
            return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
        }
    }

    // 세그먼트 트리에서 값 업데이트
    public static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) {
            return; // 범위 밖이면 리턴
        }
        tree[node] += diff; // 범위 내에 있으면 일단 더해줌
        if (start != end) { // 리프 노드가 아니라면 자식 노드들도 갱신
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, diff);
            update(node * 2 + 1, mid + 1, end, idx, diff);
        }
    }

    // 세그먼트 트리에서 구간 합 구하기
    public static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0; // 범위 밖이면 0을 반환
        }
        if (left <= start && end <= right) {
            return tree[node]; // 범위 안에 있으면 해당 노드 값 반환
        }
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 초기화
        init(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 값 변경
                long diff = c - arr[b];
                arr[b] = c; // 배열 값 갱신
                update(1, 1, N, b, diff);
            } else if (a == 2) { // 구간 합 구하기
                bw.write(sum(1, 1, N, b, (int) c) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
