import java.util.*;
class Solution {
    // 1. 스택에 원소를 하나씩 push ']'를 만날때까지
    // 2. ']'를 만났다면 하나씩 pop 한다 '['가 나올떄까지
    // 2-1 그 사이에 있던 문자를 기록해둔다.
    // 3. '['가 나왔다면 한번 더 pop해서 문자열 반복 수를 파악하고 문자를 늘린다.
    // 4. 1번으로 돌아가 반복한다.
    public static String decodeString(String s) {
        char[] str = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();

        for(int i=0;i<str.length;i++) {
            // 1
            if(str[i] != ']') {
                deque.push(str[i]);
            }
            // 2
            else {
                StringBuilder sb = new StringBuilder();
                while(true) {
                    char now = deque.pop();
                    // 3
                    if(now == '[') {
                        // number finder
                        StringBuilder numStr = new StringBuilder();
                        while(true) {
                            if(deque.isEmpty()) break;
                            if(deque.peek() >= '0' && deque.peek() <= '9') {
                                numStr.append(deque.pop());
                            } else {
                                break;
                            }
                        }
                        int numbers = Integer.parseInt(numStr.reverse().toString());


                        String word = sb.reverse().toString();
                        for(int j=1;j<numbers;j++) { // 3 1 ab+ab, 2 ab+ab+ab
                            sb.append(word);
                        }
                        break;
                    }
                    // 2-1
                    else {
                        sb.append(now);
                    }
                }
                // 다시 스택에 저장
                for(int j=0;j<sb.toString().length();j++) {
                    deque.push(sb.charAt(j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}