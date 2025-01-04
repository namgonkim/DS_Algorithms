import java.util.*;

class MinStack {
    Deque<Integer> st;
    PriorityQueue<Integer> pq;

    public MinStack() {
        st = new ArrayDeque<>();
        pq = new PriorityQueue<>();
    }
    
    public void push(int val) {
        st.push(val);
        pq.offer(val);
    }
    
    public void pop() {
        if(!st.isEmpty()) {
            int num = st.pop();
            pq.remove(num);
        }
    }
    
    public int top() {
        if(!st.isEmpty()) {
            return st.peek();
        }
        return 0;
    }
    
    public int getMin() {
        if(!pq.isEmpty()) {
            return pq.peek();
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */