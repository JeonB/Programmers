import java.util.*;
class Solution {
 private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    // DFS를 사용하여 석유 덩어리의 크기를 계산
    private static int dfs(int[][] land, int[][] cluster, int x, int y, int n, int m, int clusterId) {
        // 스택을 사용하여 DFS 구현
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        cluster[x][y] = clusterId;  // 현재 클러스터 ID로 마킹
        int size = 1; // 덩어리 크기

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1 && cluster[nx][ny] == 0) {
                    stack.push(new int[]{nx, ny});
                    cluster[nx][ny] = clusterId;
                    size++;
                }
            }
        }
        return size;
    }

    public static int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] cluster = new int[n][m]; // 석유 덩어리 ID 저장
        Map<Integer, Integer> oilSizeMap = new HashMap<>(); // 석유 덩어리 크기 저장

        int clusterId = 2; // 클러스터 ID 시작 값 (0, 1은 사용 중이므로)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && cluster[i][j] == 0) {
                    int size = dfs(land, cluster, i, j, n, m, clusterId);
                    oilSizeMap.put(clusterId, size);
                    clusterId++;
                }
            }
        }

        // 각 열을 통과하는 석유 덩어리의 크기 합산
        int maxOil = 0;
        for (int j = 0; j < m; j++) {
            Set<Integer> oilSet = new HashSet<>();
            int oilSum = 0;
            for (int i = 0; i < n; i++) {
                if (cluster[i][j] > 1) {
                    int oilIdentifier = cluster[i][j];
                    if (!oilSet.contains(oilIdentifier)) {
                        oilSum += oilSizeMap.get(oilIdentifier);
                        oilSet.add(oilIdentifier);
                    }
                }
            }
            maxOil = Math.max(maxOil, oilSum);
        }

        return maxOil;
    }
}