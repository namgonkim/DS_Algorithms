import java.util.*;

class Solution {
    // 1 2 3 ... w  <- list 
    // | | | ... |  <- Stack
    public int solution(int n, int w, int num) {
        int answer = 0;
        List<Stack<Integer>> list = new ArrayList<>();
        for(int i=0; i<w; i++) {
            Stack<Integer> st = new Stack<>();
            list.add(st);
        }
        // 리스트 큐에 하나씩 집어 넣는다. 
        int mover = 0;
        int data = 1;
        boolean isFinish = false;
        while(true) {
            Stack<Integer> st;
            if(mover % 2 == 0) {
                for(int i=0; i<w; i++) {
                    // System.out.println("idx: " + i + ", data: " + data);
                    st = list.get(i);
                    st.push(data);
                    if(data == n) {
                        isFinish = true;
                        break;
                    }
                    data++;
                }
            } else {
                for (int i=w-1; i>=0; i--) {
                    // System.out.println("idx: " + i + ", data: " + data);
                    st = list.get(i);
                    st.push(data);
                    if(data == n) {
                        isFinish = true;
                        break;
                    }
                    data++;
                }
            }
            if(isFinish) {
                break;
            }
            mover++;
        }
        
        // 리스트를 순회하며 num을 꺼낼 수 있는 스택에서 카운트를 한다. 
        for(int i=0;i<w;i++) {
            int cnt = 0;
            Stack<Integer> st = list.get(i);
            while(!st.isEmpty()) {
                int res = st.pop();
                if(res == num) {
                    return cnt+1;
                }
                cnt++;
            }
        }

        return answer;
    }
}