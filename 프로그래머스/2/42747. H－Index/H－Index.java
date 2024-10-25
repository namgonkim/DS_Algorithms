import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 0 1 3 5 6 
        // 0 1 2 3 5 6 ? 
        Arrays.sort(citations);
        for(int i=0;i<citations.length;i++) {
            // 0번, 1번, 2번 ... h번 이상 인용된 논문의 수 
            int h = citations.length - i;
            // System.out.println("h:" + h + ", citations[i]: " + citations[i]);
            // citations[i]횟수 이상 인용한게 h번 이상 
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}