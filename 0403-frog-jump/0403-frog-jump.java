import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for(int i=0;i<stones.length;i++) {
            map.put(stones[i], new HashSet<>());
        }
        // 0에서 1로 갈때 크기는 고정으로 1이다 
        map.get(0).add(1);
        // 한 돌다리씩 방문 
        for(int i=0;i<stones.length;i++) {
            int now = stones[i];
            HashSet<Integer> jumpSet = map.get(now);

            // 현재 돌다리에서 k-1, k, k+1 점프를 해서 갈 수 있는 다른 돌다리 찾기 
            for(int jump : jumpSet) {
                int next = now + jump;
                // 점프한 곳이 마지막 돌이면 건넌 것이니 트루 반환 
                if(next == stones[stones.length-1]) {
                    return true;
                }
                // 해당 위치에 돌다리가 있다면 k-1, k, k+1 점프를 해서 갈 수 있는 다른 돌다리 저장 
                if(map.containsKey(next)) {
                    map.get(next).add(jump);
                    map.get(next).add(jump+1);
                    if(jump-1 > 0) { // 양수만 
                        map.get(next).add(jump-1);
                    }
                }
            }
        }
        // 모두 탐색했는데도 돌 못건넜음 false 
        return false;
    }
}