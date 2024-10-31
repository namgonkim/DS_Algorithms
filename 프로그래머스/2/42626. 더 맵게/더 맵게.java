import java.util.*;

class Solution {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 스코빌 지수 배열을 오름차순으로 넣어두고 하나씩 꺼내서 비교한다
        for(int scov : scoville) {
            pq.offer(scov);
        }
        while(pq.size() > 1) {
            int a = pq.poll();
            // 스코빌 변경 
            if(a < K) {
                int b = pq.poll();
                // System.out.println("a: " + a + ", b: " + b);
                a = a + (b*2);
                pq.offer(a);
                answer++;
            } 
            // 스코빌을 더이상 변경할게 없으면 종료
            else {
                break;
            }
        }
        // 큐에 남아있는 원소를 체크 
        while(!pq.isEmpty()) {
            int a = pq.poll();
            if(a < K) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}