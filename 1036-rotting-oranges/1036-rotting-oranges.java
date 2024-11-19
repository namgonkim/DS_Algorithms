import java.util.*;

class Solution {
    public static int dy[] = {-1, 1, 0, 0};
    public static int dx[] = {0, 0, -1, 1};
    public static int m; // 가로
    public static int n; // 세로

    // 0: 비어있음 1: 신선함 2: 썩음
    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int oc = 0;
        int rc = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    oc++; rc++;
                    q.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    oc++;
                }
            }
        }
        if(oc == rc) return 0;
        int step = -1;
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for(int j=0; j<size;j++) {
                int[] cur = q.poll();
                int y = cur[0];
                int x = cur[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (grid[ny][nx] == 1) {
                        rc++;
                        grid[ny][nx] = 2;
                        q.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        if(oc == 0) return 0;
        else if(oc == rc) return step;
        else return -1;

    }
}