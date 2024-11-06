import java.util.*;
class Solution {
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static int n; // 세로
    public static int m; // 가로 
    public static int[] oils;
    public int solution(int[][] land) {
        // 초기화
        n = land.length;
        m = land[0].length;
        oils = new int[m];
        Arrays.fill(oils, 0);
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(land[j][i] == 1) {
                    bfs(j,i,land);
                }
            }
        }
        
        return Arrays.stream(oils).max().getAsInt();
    }
    // bfs를 이용해 주변 석유칸을 모두 탐색 
    public void bfs(int y, int x, int[][] land) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int[] point = new int[2];
        point[0] = y;
        point[1] = x;
        q.offer(point);
        land[y][x] = 2;
        set.add(x);
        while(!q.isEmpty()) {
            int[] now = q.poll();
            // 탐색 시 카운트 증가 
            count++;
            
            for(int i=0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                // 탐색 조건 
                if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if(land[ny][nx] == 1) {
                        int[] next = new int[2];
                        next[0] = ny;
                        next[1] = nx;
                        q.offer(next);
                        land[ny][nx] = 2;
                        // 탐색한 열을 셋에 담는다
                        set.add(nx);
                    }
                }
            }
        }
        // 탐색한 석유칸들을 열에 추가한다.
        for(int col : set) {
            // 기존 행에 있는 값에 추가 
            oils[col] += count;
        }
    }
}