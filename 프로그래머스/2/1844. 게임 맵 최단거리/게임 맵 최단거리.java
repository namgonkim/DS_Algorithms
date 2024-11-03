import java.util.*;
class Solution {
    // 상 하 좌 우 
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static int[][] visited;
    public static int n;
    public static int m;
    static class Node {
        int y;
        int x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                visited[i][j] = 0;
            }
        }
        
        bfs(maps);
        int answer = visited[n-1][m-1] == 0 ? -1 : visited[n-1][m-1];
        return answer;
    }
    
    public void bfs(int[][] maps) {
        // 시작점을 큐에 넣고 시작
        visited[0][0] = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        // 큐가 비지 않을때까지 탐색 
        while(!q.isEmpty()) {
            Node now = q.poll();
            // 4방향 탐색 
            for(int i=0;i<4;i++) {
                int ny = dy[i] + now.y;
                int nx = dx[i] + now.x;
                
                // 도달할 수 있는 영역 탐색
                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if(maps[ny][nx] == 1 && visited[ny][nx] == 0) {
                        visited[ny][nx] = visited[now.y][now.x] + 1;
                        Node next = new Node(ny, nx);
                        q.offer(next);
                    }
                }
            }
            
        }
    }
}