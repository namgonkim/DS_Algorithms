import java.util.*;
class Solution {
    
    public static List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        // 인접 리스트 초기화 
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }
        // 인접 리스트에 양방향으로 노드 연결
        for(int i=0;i<wires.length;i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            graph[s].add(e);
            graph[e].add(s);
        }
        int answer = Integer.MAX_VALUE;
        // 전선망 하나씩 끊는것을 반복하면서 bfs 탐색으로 노드 카운트 
        for(int i=0;i<wires.length;i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            // 1. 전선망 제거 
            // array list remove() 메소드는 리스트 안에 있는 값을 지우기 위해선 Integer.valueOf()로 감싸야함.
            graph[s].remove(Integer.valueOf(e));
            graph[e].remove(Integer.valueOf(s));
            // 2. bfs 탐색 
            boolean[] visited = new boolean[n+1];
            int nodeCount = bfs(1, visited);
            // 3. 전산망 비교 및 둘 차이 최소화
            int diff = Math.abs(nodeCount - (n-nodeCount));
            answer = Math.min(answer, diff);
            // 4. 전산망 원복 
            graph[s].add(e);
            graph[e].add(s);
        }
        return answer;
    }
    
    public int bfs(int v, boolean[] visited) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()) {
            int now = q.poll();
            
            count++;
            // 현재 노드에서 인접한 노드 목록 검색 
            for(int next : graph[now]) {
                // 방문하지 않은 노드가 있다면 큐에 추가 
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return count;
    }
}