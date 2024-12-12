import java.util.*;
class Solution {
    public static int MAX_TIME = 24*60 + 10; // 1450
    public static int HOUR = 60; // 1h = 60m
    public static int CLEAN_TIME = 10; // 10m
    
    // 누적합 알고리즘 적용해 배열의 시작엔 +1 끝엔 -1을 한 후, 앞 수를 더해 누적된 합들을 가지는 배열을 만든다.
    public int solution(String[][] book_time) {
        int[] list = new int[MAX_TIME];
        Arrays.fill(list, 0);
        // 배열 시작 끝 +1, -1 데이터 삽입 
        for(String[] book : book_time) {
            // 15:00 -> 17:00 이면 15에 1을 17에 -1을 넣는데 청소시간 10분이 있으므로 해당 길이에 1 
            int start = getTime(book[0]);
            int end = getTime(book[1]) + CLEAN_TIME;
            
            list[start] += 1;
            list[end] -= 1;
        }
        
        int answer = 0;
        // 앞 수를 더해 누적합 확인 
        for(int i=1;i<MAX_TIME;i++) {
            list[i] += list[i-1];
            // 최대 누적합을 찾는다 
            answer = Math.max(answer, list[i]);
        }
        
        
        return answer;
    }
    
    public int getTime(String strTime) {
        // 15:00 -> 15[0]/0[1] -> 15*60 + 0;
        String[] data = strTime.split(":");
        int h = Integer.parseInt(data[0]) * HOUR;
        int m = Integer.parseInt(data[1]);
        
        return h+m;
    }
}