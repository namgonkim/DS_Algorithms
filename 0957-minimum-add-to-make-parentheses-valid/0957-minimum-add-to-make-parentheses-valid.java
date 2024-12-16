import java.util.*;
class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int answer = 0;
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == '(') {
                st.push('(');
            }
            else if(arr[i] == ')') {
                if(!st.isEmpty()) {
                    st.pop();
                }
                else {
                    answer++;
                }
            }
        }
        // 스택 갯수만큼 ++ 
        while(!st.isEmpty()) {
            st.pop();
            answer++;
        }

        return answer;
    }
}