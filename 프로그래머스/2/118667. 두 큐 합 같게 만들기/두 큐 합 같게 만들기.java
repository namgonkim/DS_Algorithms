import java.util.*;
class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        ArrayList<Integer> q1 = new ArrayList<>();
        ArrayList<Integer> q2 = new ArrayList<>();
        for(int data : queue1) q1.add(data);
        for(int data : queue2) q2.add(data);
        
        // 한쪽 큐가 두 원소의 합 / 2가 될 수 있는 경우를 찾으면 된다.
        long total = 0;
        long a = 0, b = 0;
        for(int data : queue1) a += data;
        for(int data : queue2) b += data;
        total = (a+b) / 2;
        
        // 3,2,7,2 / 4,6,5,1 = 30 / 2 => 15
        int p1 = 0;
        int p2 = 0;
        boolean notFound = false;
        while(true) {
            // 두 큐의 합이 같거나 카운트가 종료 조건인 경우
            if(a == b) {
                break;
            } 
            if(answer > (queue1.length + queue2.length) * 2) {
                notFound = true;
                break;
            }
            // a큐가 b큐보다 크면 a에서 빼서 b에 추가
            if(a > b) {
                a -= q1.get(p1);
                b += q1.get(p1);
                q2.add(q1.get(p1));
                p1++;
            } else {
                b -= q2.get(p2);
                a += q2.get(p2);
                q1.add(q2.get(p2));
                p2++;
            }
            answer += 1;
            // System.out.println("answer: " + answer + ", a:" + a + ", b:" + b);
        }
        if(notFound) return -1;
        return answer;
    }
}