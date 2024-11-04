import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int minIdx = 0;
        int maxIdx = people.length-1;
        // 정렬 후 무게 많은 사람 + 무게 적은 사람 으로 찾아나감
        while(minIdx <= maxIdx) {
            // 무게 가장 많은 사람과 무게 가장 적은 사람이 구명보트에 탈 수 있으면 
            if(people[minIdx] + people[maxIdx] <= limit) {
                // 한명씩 태우고 다음 사람으로 돌린다
                minIdx++;
                maxIdx--;
            } else {
                // 아니라면 큰사람은 따로 타게 한다
                maxIdx--;
            }
            answer++;
        }
        
        return answer;
    }
}