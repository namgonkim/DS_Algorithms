import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        // 연속적으로 나타나는 값만 제거하면 된다. 
        for(int i=0;i<arr.length;i++) {
            // i가 0이 아니면서 i번째 원소와 i-1번째 원소 값이 같으면 패스
            if(i != 0 && arr[i] == arr[i-1]) {
                continue;
            }
            list.add(arr[i]);
        }
        
        // 결과 도출 
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}