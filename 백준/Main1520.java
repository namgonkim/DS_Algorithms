package backjoon;

import java.util.*;
/*
문제: 내리막 길(1520)
유형: bfs/pq/dp
날짜: 2021.07.25 (일)
 */
class Pairs implements Comparable<Pairs>{
    int x;
    int y;
    int height;

    public Pairs(int y, int x, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    // 높이 별 내림차순 정렬
    @Override
    public int compareTo(Pairs p1) {
        return Integer.compare(p1.height, this.height);
    }

}

public class Main1520 {

    public static int m, n; // 세로 크기 . 가로 크기
    public static int[][] graph;
    public static int[][] visited; // 현재 좌표까지 올 수 있는 경로를 저장

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public void solution(int y, int x, int height) {

        PriorityQueue<Pairs> q = new PriorityQueue<>();
        visited[y][x] = 1;
        q.add(new Pairs(y,x, height));

        while(!q.isEmpty()) {
            Pairs pair = q.poll();
            y = pair.y;
            x = pair.x;

            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(ny >= 0 && ny < m && nx >= 0 && nx < n) {
                    // 높이가 더 낮은 지점으로만 이동
                    if(graph[ny][nx] < graph[y][x]) {
                        // 현재 좌표를 방문했는데, 이게 이전에 이미 방문한 적이 있는 경우면 경로의 수만 더해주면 된다.
                        if(visited[ny][nx] == 0) {
                            q.add(new Pairs(ny,nx,graph[ny][nx]));
                        }
                        visited[ny][nx] += visited[y][x];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main1520 main = new Main1520();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[m][n];
        visited = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        main.solution(0,0, graph[0][0]);
        System.out.println(visited[m-1][n-1]);
    }
}
