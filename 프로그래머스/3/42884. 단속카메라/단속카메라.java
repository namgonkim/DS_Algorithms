import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 종료 시점을 기준으로 오름차순 정렬 
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int answer = 0;
        // 캠 위치 
        int cam = -30001;
        for(int[] route : routes) {
            // 현재 캠 위치가 차량 진입 보다 더 앞에 있다면 (이전 카메라가 설치한 곳에서 못보면) 
            // 새로운 캠을 route 종료지점에 설치 
            if(route[0] > cam) {
                answer++;
                cam = route[1];
            }
        }
        
        return answer;
    }
}