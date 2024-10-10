import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class BusRoute {
        int start, end, time;

        BusRoute(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    static int N, M;
    static BusRoute[] busRoutes;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        busRoutes = new BusRoute[M];
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 1번 도시에서 출발

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            busRoutes[i] = new BusRoute(A, B, C);
        }

        // 벨만-포드 알고리즘
        boolean hasNegativeCycle = bellmanFord();

        if (hasNegativeCycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
        sc.close();
    }

    static boolean bellmanFord() {
        // N-1번 반복
        for (int i = 0; i < N - 1; i++) {
            for (BusRoute route : busRoutes) {
                if (dist[route.start] != INF && dist[route.end] > dist[route.start] + route.time) {
                    dist[route.end] = dist[route.start] + route.time;
                }
            }
        }

        // 음수 사이클 확인
        for (BusRoute route : busRoutes) {
            if (dist[route.start] != INF && dist[route.end] > dist[route.start] + route.time) {
                return true; // 음수 사이클 존재
            }
        }
        return false; // 음수 사이클 없음
    }
}
