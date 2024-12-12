import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 부를때마다 등수가 한 단계 올라간다. 
        // 순번을 맵에다가 넣어두고 외칠때마다 맵에서 인덱스를 찾아 players 배열의 값을 교체해준다면? 
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<players.length;i++) {
            map.put(players[i], i);
        }
        for(String calling : callings) {
            // map에서 calling의 인덱스를 찾는다.
            int callIdx = map.get(calling);
            // 앞에 등수와 자리를 바꾼다. 1등이라면 하지 않는다
            if(callIdx == 0) continue;
            String temp = players[callIdx];
            players[callIdx] = players[callIdx-1];
            players[callIdx-1] = temp;
            // 등수를 바꿨으면 map도 변경한다. 주의: callIdx 인덱스에는 이미 변경된 데이터임
            map.put(calling, callIdx-1);
            map.put(players[callIdx], callIdx);
        }
        // String[] answer = {};
        return players;
    }
}