import java.util.*;

class Solution {
    // 상 하 좌 우 
    public static int[] dy = {-1,1,0,0};
    public static int[] dx = {0,0,-1,1}; 
    public static boolean[][] visited;
    
    public int bfs(int m, int n, int y, int x, int[][] picture) {
        int cnt = 1;
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        
        int color = picture[y][x];
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i=0;i<4;i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[ny][nx] && picture[ny][nx] == color) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    int res = bfs(m,n,i,j, picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(res, maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}