import java.util.*;
class Solution {
    // numbers의 숫자를 조합해 나올 수 있는 수 중 소수인 숫자의 카운트를 구하는 문제. 
    // numbers의 조합을 구한다. 
    // 0 1 1 -> 0, 1, 11, 10, 101, 110 
    public static Set<Integer> set = new HashSet<>();
    public static boolean[] visited = new boolean[7];
    
    
    public int solution(String numbers) {
        dfs(numbers, "", 0); // 숫자 조합을 만들어 나간다.
        
        // for(int i : set) System.out.println(i);
        
        // 소수인지 판별
        int answer = 0;
        for(int num : set) {
            if(num == 0 || num == 1) continue;
            int cnt = 0;
            for(int i=1;i<=num/2;i++) {
                if(num % i == 0) cnt++;
            }
            if(cnt == 1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(String numbers, String num, int cnt) {
        // 종료 조건 
        if(cnt == numbers.length()) {
            return;
        }
        
        for(int i=0;i<numbers.length();i++) {
            // 문자열 중에 방문하지 않았다면 
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(num + numbers.charAt(i)));
                dfs(numbers, num + numbers.charAt(i), cnt+1);
                visited[i] = false;
            }
        }
    }
}