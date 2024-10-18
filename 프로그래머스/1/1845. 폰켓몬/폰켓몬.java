import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        // 중복되지 않는 포켓몬을 골라 그 종류의 갯수를 파악하고, n/2보다 작으면 포켓몬 종류의 최대 갯수가 된다. 
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) numSet.add(num);
        if(numSet.size() < nums.length/2) answer = numSet.size();
        return answer;
    }
}