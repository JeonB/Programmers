import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] blackHoles = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            blackHoles[i] = Integer.parseInt(st.nextToken());
        }

        Asteroid[] asteroids = new Asteroid[M];
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int a_j = Integer.parseInt(st.nextToken());
            int w_j = Integer.parseInt(st.nextToken());
            asteroids[j] = new Asteroid(a_j, w_j);
        }

        Arrays.sort(blackHoles);
        Arrays.sort(asteroids);

        long left = 0, right = 200000000L;
        while (left < right) {
            long mid = (left + right) / 2;
            if (canAbsorbAll(blackHoles, asteroids, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        bw.write(left + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean canAbsorbAll(int[] blackHoles, Asteroid[] asteroids, long P) {
        int n = blackHoles.length;
        int m = asteroids.length;

        int i = 0; // Black hole index
        for (int j = 0; j < m; j++) {
            while (i < n && !canAbsorb(blackHoles[i], asteroids[j], P)) {
                i++;
            }
            if (i == n) {
                return false;
            }
        }
        return true;
    }

    static boolean canAbsorb(int blackHole, Asteroid asteroid, long P) {
        return Math.abs(blackHole - asteroid.position) <= P / asteroid.mass;
    }

    static class Asteroid implements Comparable<Asteroid> {
        int position;
        int mass;

        Asteroid(int position, int mass) {
            this.position = position;
            this.mass = mass;
        }

        @Override
        public int compareTo(Asteroid other) {
            return Integer.compare(this.position, other.position);
        }
    }
}