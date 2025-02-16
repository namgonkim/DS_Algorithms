import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // 배열을 끝점 기준으로 오름차순 정렬 후, 각 끝점이 다음 시작점보다 짧으면 이전 끝점에서 요격 
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        // 끝점보다 다음 i번째의 시작점이 크면 카운트 
        int max = 0;
        for(int i=0; i<targets.length; i++) {
            if(max <= targets[i][0]) {
                answer++;
                max = targets[i][1];
            }
        }
        
        return answer;
    }
}