import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        List<Character> list = new ArrayList<>();
        // map에 x 값, 카운트 세고 y를 map에서 찾아보는데 키가 있으면서 카운트가 남아있다면 가능
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<X.length();i++) {
            char c = X.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i=0;i<Y.length();i++) {
            if(map.containsKey(Y.charAt(i))) {
                if(map.get(Y.charAt(i)) > 0) {
                    map.put(Y.charAt(i), map.get(Y.charAt(i)) - 1);
                    list.add(Y.charAt(i));
                }
            }
        }
        // list가 아예 없으면 -1
        if(list.size() == 0) {
            return "-1";
        }
        
        // 정렬 후 answer에 작성 O(NlogN) 시간이 안되면 숫자를 뽑은 의미가? 
        Collections.sort(list);
        // 제일 큰 수가 0이면 0으로 리턴 
        if(list.get(list.size()-1) == '0') {
            return "0";
        }
        
        // 문자열 리터럴 덧셈이 잦아서 그런거라면? 
        StringBuilder sb = new StringBuilder(); 
        for(int i=list.size()-1;i>=0;i--) {
            sb.append(list.get(i) + "");
        }
        return sb.toString();
    }
}