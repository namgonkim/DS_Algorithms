import java.util.*;
class Solution {
    public static int cnt = 0;
    public static boolean[] visited;

    // 현재 노드에서 갈수 있는 모든 노드 탐색
    public void dfs(int node, int n, int[][] computers) {
        visited[node] = true;
        
        for(int i=0;i<n;i++) {
            // 인접한 노드 중에 방문하지 않았다면 간다
            if(visited[i] == false && computers[node][i] == 1) {
                dfs(i, n, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        Arrays.fill(visited, false);
        for(int i=0;i<n;i++) {
            if(visited[i] == false) {
                // dfs로 연결된 다른 노드 다 탐색함 
                dfs(i, n, computers);
                cnt += 1;
            }
        }
        
        return cnt;
    }
}