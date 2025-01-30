import java.util.*;
class Solution {
    // 최소한의 화살로 모든 풍선 터트리기
    // points : [0]x시작 / [1]x끝  
    // 끝점을 기준으로 화살을 쏜다. 
    public int findMinArrowShots(int[][] points) {
        // 화살쏘기 전에 풍선 x좌표 끝점을 기준으로 오름차순 정렬 
        Arrays.sort(points, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]); 
        });
        int cnt = 1;
        int prev = points[0][1];
        for(int i=1; i<points.length; i++) {
            // 현재 풍선이 이전 풍선 끝점을 넘어서면 이전까지 풍선들을 화살을 쏴서 터트린다. 
            if(points[i][0] > prev) {
                cnt++;
                prev = points[i][1];
            }
        }

        return cnt;
    }
}