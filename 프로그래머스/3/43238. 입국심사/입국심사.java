import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = 0;
        long end = times[times.length-1]*(long)n; // n명 모두 제일 오래걸리는 심사관에게 갔을 떄 
        while(start <= end) {
            long mid = (start+end)/2;
            // mid 시간 내에 심사할 수 있는 최대한의 사람
            long simsa = 0;
            for(int time : times) {
                // 30 -> 4 + 3 = 7명
                simsa = simsa + (mid/time);
            }
            // 심사한 사람이 n명보다 작으면 mid 시간안에 n명을 다 심사할 수 없음 
            if(simsa < n) {
                start = mid + 1;
            }
            // 심사한 사람이 n명 이상이면 mid 시간안에 n명 다 심사할 수 있음 
            else {
                answer = mid;
                end = mid - 1;
            }
        }
        return answer;
    }
}