import java.util.*;

class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 가중치를 기준으로 간선들을 정렬하기 위해 compareTo 메서드를 구현
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int[] parent;

    // Find 연산: 루트 노드를 찾기 위한 함수 (경로 압축 포함)
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // Union 연산: 두 집합을 합치는 함수
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수

        List<Edge> edges = new ArrayList<>();

        // 간선 정보 입력받기
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(from, to, weight));
        }

        // 간선들을 가중치 기준으로 정렬
        Collections.sort(edges);

        // Union-Find에서 부모 테이블 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int mstWeight = 0; // 최소 스패닝 트리의 가중치
        int edgeCount = 0; // 선택된 간선의 수

        // Kruskal 알고리즘 실행
        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                mstWeight += edge.weight;
                edgeCount++;

                // 정점의 개수 - 1개의 간선이 선택되면 최소 스패닝 트리가 완성됨
                if (edgeCount == V - 1) {
                    break;
                }
            }
        }

        // 최소 스패닝 트리의 가중치를 출력
        System.out.println(mstWeight);
    }
}
