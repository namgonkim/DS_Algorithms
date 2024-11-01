import java.util.*;

class Solution {
    public static Map<String, Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        int answer = 1;
        // 2,1개씩 있을 경우 조합 -> 3*2 - 1
        for(String key : map.keySet()) {
            answer = answer * (map.get(key) + 1);
        }
        return answer - 1;
    }
}