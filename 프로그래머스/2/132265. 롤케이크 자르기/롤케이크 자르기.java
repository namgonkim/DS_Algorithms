import java.util.*;

class Solution {
    public static Map<Integer, Integer> young = new HashMap<>();
    public static Set<Integer> old = new HashSet<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        // 동생이 모든 토핑 종류와 갯수를 가지고 있음 
        for(int type : topping) {
            young.put(type, young.getOrDefault(type, 0) + 1);
        }
        // 형한테 하나씩 건내줌 
        for (int type : topping) {
            old.add(type);
            // 형한테 준게 동생한테도 있으면 갯수 감소
            if(young.containsKey(type)) {
                young.put(type, young.get(type) - 1);
                // 만약 갯수 없으면 다 나눠준거니까 동생도 없어져야 함
                if(young.get(type) == 0) {
                    young.remove(type);
                }
            }
            
            // 형이랑 동생 사이즈 같으면 공평하게 나눈것
            if(young.size() == old.size()) {
                answer += 1;
            }
        }
        return answer;
    }
}