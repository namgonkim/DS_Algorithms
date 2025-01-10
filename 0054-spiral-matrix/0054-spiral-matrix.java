// 1. 오른쪽, 아래, 왼쪽, 위 순서를 반복하며 순회
// 2. 방문한 지점은 재방문하지 않도록 체크 
import java.util.*;
class Solution {
    public int[] dy = {0, 1, 0, -1};
    public int[] dx = {1, 0, -1, 0};
    public boolean[][] visited;

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y=y;
            this.x=x;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        visited = new boolean[n][m];

        List<Integer> list = new ArrayList<>();

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));

        int d = 0;
        while(!q.isEmpty()) {
            Point now = q.poll();
            list.add(matrix[now.y][now.x]);
            visited[now.y][now.x] = true;

            // 왜 종료조건을 명시해야할까? 아마도 방향이 꺾이는 것 때문일 것 
            if(list.size() == m*n) {
                break;
            }

            int ny = now.y + dy[d];
            int nx = now.x + dx[d];

            // 더이상 한 방향으로 이동할 수 없을 때까지 이동 
            if((ny >= 0 && ny < n && nx >= 0 && nx < m) && !visited[ny][nx]){
                q.offer(new Point(ny, nx));
            }
            // 방향을 바꾼 ny,nx를 큐에 삽입.
            else {
                d += 1;
                if(d == 4) {
                    d = 0;
                }
                ny = now.y + dy[d];
                nx = now.x + dx[d];
                q.offer(new Point(ny, nx));
            }
            
        }
        return list;
    }
}