import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] arr = s.toCharArray();
        char x = arr[0];
        int xCnt = 1;
        int otherCnt = 0;
        int i=1;
        for(; i<arr.length; i++) {
            if(x != arr[i]) {
                otherCnt++;
            } else {
                xCnt++;
            }
            // xCnt == otherCnt, 문자열 분리 
            if(xCnt == otherCnt) {
                answer++;
                // System.out.println(x);
                if(i+1 >= arr.length) {
                    break;
                }
                x = arr[i+1];
                i++;
                xCnt = 1;
                otherCnt = 0;
            }
        }
        // 끝나고 한 단어 남았으면 한번 더 분리
        if(i == arr.length) answer++;
        
        return answer;
    }
}