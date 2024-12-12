import java.util.*;
class Solution {
    // 친구들의 그리움 점수를 맵에 담고 포토를 보며 그리움 점수를 합산하는 문제 
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++) {
            map.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            int count = 0;
            for(String friend : photo[i]) {
                // 친구가 map에 있으면 저장.
                count += map.getOrDefault(friend, 0);
            }
            answer[i] = count;
        }
        
        return answer;
    }
}