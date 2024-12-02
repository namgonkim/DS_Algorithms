import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        // divisor이 0이면 -1리턴 
        if(divisor == 0) {
            return new int[]{-1};
        }
        // 배열 오름차순 정렬 
        Arrays.sort(arr);
        // 원소를 O(N)으로 탐색하며 divisor로 나눠 떨어진다면 리스트에 추가
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        // 나누어 떨어지는 값이 없다면 -1 리턴 
        if(list.size() == 0) {
            return new int[]{-1};
        }
        // 결과 도출 
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}