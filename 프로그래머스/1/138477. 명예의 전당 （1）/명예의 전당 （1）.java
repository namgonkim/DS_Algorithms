import java.util.*;

class Solution {
    // 우선순위 큐에 넣고 큐의 사이즈가 K 이상이면 젤 위에 애를 팝하면 되지 않을까? 
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<score.length;i++) {
            pq.offer(score[i]);
            
            // pq 사이즈가 k와 같아질때까지 하위 제거
            while(pq.size() > k) {
                pq.poll();
            }
            
            answer[i] = pq.peek();
        }

        return answer;
    }
}