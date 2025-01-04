import java.util.*;

class Solution {
    class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // 1. 0의 위치를 기억하고 있기 
        List<Point> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) {
                    Point p = new Point(i,j);
                    list.add(p);
                }
            }
        }

        // 2. 0의 위치의 행과 열을 모두 0으로 바꾸기 
        for(Point p : list) {
            // y축에 있는 x를 모두 0으로 바꾸기 
            for(int i=0;i<m;i++) {
                matrix[p.y][i] = 0;
            }
            // x축에 있는 y를 모두 0으로 바꾸기 
            for(int i=0;i<n;i++) {
                matrix[i][p.x] = 0;
            }
        }

    }
}