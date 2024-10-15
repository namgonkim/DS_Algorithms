import java.util.*;
import java.io.*;

public class Main {
    public static int[] dist;
    public static ArrayList<Node>[] graph;
    public static int MAX = 100000000;
    
    static class Node implements Comparable<Node> {
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
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        // 그래프 초기화 
        dist = new int[v+1];
        Arrays.fill(dist, MAX);
        graph = new ArrayList[v+1];
        for(int i=1;i<=v;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
        }
        // 다익스트라 
        dijkstra(start);
        for(int i=1; i<=v;i++) {
            if(dist[i] >= MAX) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        // 비어있지 않다면 
        while(!pq.isEmpty()) {
            // 현재 노드를 큐에서 꺼낸다 
            Node now = pq.poll();
            int index = now.index;
            int cost = now.cost;
            // 현재 index의 최단 경로가 cost보다 작다면 이미 방문한 적이 있음으로 패스 
            if(dist[index] < cost) {
                continue;
            }
            
            // 현재 노드에서 방문 가능한 주변 노드를 그래프에서 탐색
            for(Node next : graph[index]) {
                // 방문한 노드의 최단 경로가 현재 노드까지의 최단 경로에서 다음 노드까지 가는 비용합보다 크면 갱신, 다음 큐에서 검색
                if(dist[next.index] > dist[index] + next.cost) {
                    dist[next.index] = dist[index] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}