import java.util.*;

class Solution {
    // 문자열 내에 괄호쌍이 올바르지 않으면 삭제해야 함 
    public String minRemoveToMakeValid(String s) {
        int left = 0;
        int right = 0;
        Deque<Character> st = new ArrayDeque<>();
        // (와 ) 개수를 세아리면서 불필요한 닫이 문자를 먼저 제거 
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            }
            else if(s.charAt(i) == ')') {
                right++;
            }
            // 만약 right가 더 큰 상태면 스택에 넣지 않음. 
            if(right > left) {
                right--;
            } else {
                st.push(s.charAt(i));
            }
        }

        // 반대로 스택에서 꺼내면서 불필요한 ( 문자 제거 
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            char c = st.pop();
            // 문자가 (이면서 left가 더 크면? 불필요한 문자 
            if(left > right && c == '(') {
                left--;
            } else {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }
}