import java.util.*;
class Solution {
    // 반복되는 문자가 없는 가장 긴 부분 문자열을 찾기
    // 투포인터 알고리즘을 적용
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int answer = 0;
        char[] word = s.toCharArray();
        for(int right=0; right<word.length; right++) {
            // 반복되는 문자를 찾을때까지 left를 앞으로 밀면서 저장한 문자를 제거해나간다.
            while(set.contains(word[right])) {
                set.remove(word[left]);
                left++;
            }
            // 반복되는 문자가 없으면 저장하고 현재 두 포인터 사이의 거리를 최장거리로 업데이트한다.
            set.add(word[right]);
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
        
    }
}