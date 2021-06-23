package solution;


import java.util.*;
/*
이름: 게임 맵 최단거리
유형: BFS
날짜: 2021.06.23
 */
class Solution {

    // 좌 우 상 하
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;

    static int[][] map;
    static boolean[][] visited;


    public static int bfs(int y, int x, int[][] maps){
        int answer = 0;
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();

        int[] node = {y,x};
        q.add(node);

        while(!q.isEmpty()){
            int[] now = q.poll();
            x = now[1];
            y = now[0];

            for(int i=0;i<4;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if(maps[ny][nx] != 0 && visited[ny][nx] == false) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                        map[ny][nx] = map[y][x] + 1;
                        if(ny == n-1 && nx == m-1){
                            answer = map[ny][nx];
                            return answer;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = maps[i][j];
            }
        }
        visited = new boolean[n][m];

        answer = bfs(0,0, maps);

        return answer;
    }

    public static void main(String[] args) {
        //[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
        //[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int answer = solution(maps);
        System.out.println(answer);

    }
}