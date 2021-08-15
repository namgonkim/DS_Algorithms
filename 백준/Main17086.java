import java.util.*;
/*
문제: 아기 상어2 (백준 17086)
유형: bfs
날짜: 2021.08.16 (월)
*/

class Pair {
    int y;
    int x;
    
    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Main {
    
    // 상하좌우 상좌 상우 하좌 하우
    public static int[] dy={-1,1,0,0,-1,-1,1,1};
    public static int[] dx={0,0,-1,1,-1,1,-1,1};
    public static int[][] board; // n x m space 
    public static int[][] dist;
    public static int n, m;
    public static Queue<Pair> q = new LinkedList<>();
    
    public int bfs() {
        int result = 0;
        
        while(!q.isEmpty()) {
            Pair now = q.poll();
            
            for(int i=0;i<8;i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                
                if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    // 현재 거리가 이전 거리보다 짧으면 + 1
                    if(dist[ny][nx] > dist[now.y][now.x] + 1){
                        dist[ny][nx] = dist[now.y][now.x] + 1;
                        q.add(new Pair(ny,nx));
                        result = Math.max(dist[ny][nx], result);
                    }
                }
            }
        }
        
        return result;
    }
    
    public int solution() {
        int answer = 0;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == 1) {
                    q.add(new Pair(i,j));
                    dist[i][j] = 0;
                }
            }
        }
        answer = bfs();
        
        return answer;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        dist = new int[n][m];
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                board[i][j] = sc.nextInt();
                dist[i][j] = (int)1e9;
            }
        }
        
        System.out.println(main.solution());
        
    }
    
}
