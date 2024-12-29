import java.util.*;
class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int answer = 0;
        // 문자열 s에서 부분 문자열이 등장하는 횟수를 세기 위한 해시맵 
        Map<String, Integer> map = new HashMap<>();

        for(int j=0; j<=s.length()-minSize; j++) {
            // 부분 문자열 subs를 만든다.
            String subs = s.substring(j, j+minSize);
            Set<Character> alpha = new HashSet<>();
            for(char c : subs.toCharArray()) {
                alpha.add(c);
            }
            // 부분 문자열 subs에 maxLetters만큼의 문자 갯수보다 초과되면 찾아보지 않는다. 
            if(maxLetters < alpha.size()) {
                continue;
            }
            // 문자열 s에서 부분 문자열 subs의 등장 횟수 새기 
            map.put(subs, map.getOrDefault(subs, 0) + 1);
            // 젤 많이 나오는 값으로 변경 
            answer = Math.max(answer, map.get(subs));
        }
        return answer;
    }
}