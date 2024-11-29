import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long right = times[times.length-1] * (long)n;
        long left = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            // System.out.println(mid);
            
            long count = 0;
            // mid 시점 기준으로 심사할 수 있는 사람 수가 
            for(int i=0;i<times.length;i++) {
                count = count + (mid / times[i]);
            }
            // 아직 충분히 들어갈 수 있는 mid시점이라면 
            if(count >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}

// t=10, [10,20,30,40,50,60]
// t=7,  [7,14,21,28,35,42]
// t=7,10 [7,10,14,20,21,28]

// 최대로 걸리는 시간이 6명이 모두 10번대로 가는것
// 그러면 시간을 기점으로 0,1,...60까지 했을 떄 얼마나 많은 사람이 들어올 수 있는지를 계산하면 된다. 
// 이걸 이분 탐색으로 찾아본다. 