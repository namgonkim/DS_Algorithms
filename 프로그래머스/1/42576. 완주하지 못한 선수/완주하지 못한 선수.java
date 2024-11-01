import java.util.*;

class Solution {
    
    public static Map<String, Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        for(String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        for(String comp : completion) {
            if(map.containsKey(comp)) {
                map.put(comp, map.get(comp) - 1);
            }
        }
        
        String answer = "";
        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}