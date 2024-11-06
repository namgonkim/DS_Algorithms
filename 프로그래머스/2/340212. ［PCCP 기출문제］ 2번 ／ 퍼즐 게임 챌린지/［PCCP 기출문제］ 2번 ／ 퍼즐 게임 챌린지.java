import java.util.*;

class Solution {
    // 해결할 수 있는 level(숙련도)를 찾아나가는데, diff 최대-최소 사이에서 제일 작은 숙련도 찾기
    public int solution(int[] diffs, int[] times, long limit) {
        int right = 300000;
        int left = 1;
        int answer = right;
        while(left < right) {
            long time = 0;
            int level = (left + right) / 2;
            for(int i=0; i<diffs.length; i++) {
                if(diffs[i] > level) {
                    time = time + (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
                } else {
                    time = time + times[i];
                }
            }
            // 최종적으로 걸린 시간이 리밋 이하일때는 숙련도가 적합하다.
            if(time <= limit) {
                answer = Math.min(answer, level);
                // 더 작은 숙련도가 나올 수 있으니 한칸 내려서 찾아본다
                right = level;
            } else {
                left = level + 1;
            }
        }
        return answer;
    }
}