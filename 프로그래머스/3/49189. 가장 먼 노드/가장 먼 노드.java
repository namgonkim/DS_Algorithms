import java.util.*;
class Solution {
    class Node implements Comparable<Node> {
        int index;
        int cost;
        
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    // 1번 노드로부터 가장 멀리 떨어진 노드의 거리 
    public static int MAX_DIST = 0;
    // 2차원 그래프
    public static List<Node>[] graph;
    // n개의 노드에서 시작 노드로 가기 위한 최단 경로 배열
    public static int[] dist;
    public int solution(int n, int[][] edge) {
        // dist 초기화 
        dist = new int[n+1];
        Arrays.fill(dist, 100_000_000);
        // 그래프 초기화 
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        // 엣지를 그래프에 연결 
        for(int i=0;i<edge.length;i++) {
            // edge[i][0] - edge[i][1] = 1;
            graph[edge[i][0]].add(new Node(edge[i][1], 1));
            graph[edge[i][1]].add(new Node(edge[i][0], 1));
        }
        
        // 다익스트라 
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        while(!pq.isEmpty()) {
            Node nowNode = pq.poll();
            // System.out.println(nowNode.cost);
            // System.out.println(dist[nowNode.index]);
            // 이미 노드가 처리된 적이 있다면 무시 
            if(dist[nowNode.index] < nowNode.cost) {
                continue;
            }
            // 현재 노드와 인접한 노드 확인 
            for(Node next : graph[nowNode.index]) {
                // System.out.println(next.index);
                // System.out.println(dist[next.index]);
                if(dist[next.index] > dist[nowNode.index] + next.cost) {
                    dist[next.index] = dist[nowNode.index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                    
                    // MAX_DIST
                    if(MAX_DIST < dist[next.index]) {
                        MAX_DIST = dist[next.index];
                        // System.out.println(MAX_DIST);
                    }
                }
            }
        }
        
        // dist 돌면서 MAX_DIST와 같은 점수를 가지는 친구 찾기 
        int answer = 0;
        for(int i=1; i<=n; i++) {
            // System.out.println(dist[i]);
            if(dist[i] == MAX_DIST) {
                answer++;
            }
        }
        return answer;
    }
}