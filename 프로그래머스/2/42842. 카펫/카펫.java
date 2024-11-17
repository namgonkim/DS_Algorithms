import java.util.*;

class Solution {
    class Point {
        int x;
        int y;
        
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public int[] solution(int brown, int yellow) {
        int len = brown+yellow;
        List<Point> points = new ArrayList<>();
        for(int i=1;i<=len/2;i++) {
            // i로 나눴을 때 나머지가 0이면 좌표로 사용 가능 
            if(len%i==0) {
                int mock = len / i;
                // 몫이 나누는 값보다 크거나 같을 때만 사용 
                if(mock >= i) {
                    // 몫: 가로, 나누는 값: 세로
                    points.add(new Point(i, mock));
                }
            }
        }
        
        // 좌표 리스트 중에서 찾아내기 
        int[] answer = new int[2];
        for(Point point : points) {
            int y = point.y;
            int x = point.x;
            int cnt = 0;
            for(int i=1;i<y-1;i++) {
                for(int j=1;j<x-1;j++) {
                    cnt++;
                }
            }
            // yellow 색과 같으면 잘 찾은것 
            if(cnt == yellow) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        
        return answer;
    }
}