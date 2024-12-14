import java.util.*;

class Solution {
    // 문자열을 index만큼 변경하는데, skip에 있는 알파벳은 세지 않고 넘어간다. 
    // index만큼 뒤로 이동했을 때 z를 넘어가면 a로 변경한다
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet<>();
        for(int i=0;i<skip.length();i++) {
            set.add(skip.charAt(i));
        }
        // index 만큼 뒤로 미뤄본다 
        String answer = "";
        for(int i=0;i<s.length();i++) {
            int count = 0;
            char c = s.charAt(i);
            // 인덱스까지 알파벳 하나씩 미룬다. 
            while(count < index) {
                c += 1;
                // c가 z를 넘어가면 a로 변경 
                if(c > 'z') {
                    c = 'a';
                }
                // skip에 있는 알파벳은 제외한다. 
                if(!set.contains((char)c)) {
                    count++;
                }
            }
            answer += c + "";
        }
        return answer;
    }
}