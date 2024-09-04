import java.util.*;
class Solution {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int subtreeNodeCount;

    public static int solution(int n, int[][] wires) {
        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 정보로 그래프 구성
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        int minDifference = Integer.MAX_VALUE;

        // 각 간선을 하나씩 제거하면서 트리를 두 개의 서브트리로 나누어봄
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 간선을 제거하여 두 서브트리로 나눔
            visited = new boolean[n + 1];
            visited[v2] = true; // 임의로 v2를 끊어진 노드로 가정
            subtreeNodeCount = 0;
            
            // v1에서 시작하여 v2가 제거된 상태로 서브트리 크기 구함
            dfs(v1);
            
            int otherSubtreeCount = n - subtreeNodeCount;
            int difference = Math.abs(subtreeNodeCount - otherSubtreeCount);
            
            // 최소 차이 갱신
            minDifference = Math.min(minDifference, difference);
        }
        
        return minDifference;
    }

    // DFS를 이용하여 서브트리의 노드 개수를 세는 함수
    private static void dfs(int node) {
        visited[node] = true;
        subtreeNodeCount++;
        
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}