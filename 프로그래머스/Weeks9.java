/*
문제: 전력망 둘로 나누기
유형: union-find (dfs로도 풀이 가능)
날짜: 2021.10.15 (금)
*/
public class Weeks9 {
    public static int[] parent;

    public int find_parent(int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent[x]);
        }
        return parent[x];
    }

    public void union_parent(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = 101;
        parent = new int[n + 1];
        // 모든 wires 수만큼 하나씩 간선 짤라가며 파악한다.
        for (int i = 0; i < n - 1; i++) {
            // 부모 노드 초기화
            for (int j = 1; j < n + 1; j++) {
                parent[j] = j;
            }
            // wires[i] 간선을 짤라 두 트리로 만들고 union-find
            for (int j = 0; j < wires.length; j++) {
                // 짜른 간선은 제외하고 나머지 이어준다.
                if (i != j) {
                    int a = wires[j][0];
                    int b = wires[j][1];

                    union_parent(a, b);
                }
            }
            // 1번 노드와 이어진 트리에 노드 개수 찾기
            int counts = 0;
            for (int j = 1; j < n + 1; j++) {
                // 현재 j의 부모 노드가 1이라면은 카운트 + 1
                if (find_parent(parent[j]) == 1) {
                    counts += 1;
                }
            }
            // 두 트리 간 노드 개수 차이 구하기
            int tree1 = counts;
            int tree2 = n - counts;
            int res = Math.abs(tree1 - tree2);

            // 두 트리가 가장 비슷하도록 하는 최소 차 개수 얻기
            answer = Math.min(answer, res);
        }

        return answer;
    }
}
