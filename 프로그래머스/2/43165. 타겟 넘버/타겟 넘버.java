class Solution {
    public static int cnt = 0;
    public void dfs(int i, int n, int value, int target, int[] numbers) {
        // n번만큼 수행했으면 종료 
        if(i == n-1) {
            // 최종 값이 target과 동일하면 정답 변경 
            if(value == target) {
                // System.out.println("i: " + i + ", value: " + value);
                cnt+=1;
            }
            return;
        }
        
        dfs(i+1, n, value+numbers[i+1], target, numbers);
        
        dfs(i+1, n, value-numbers[i+1], target, numbers);
    }
    
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        dfs(-1, n, 0, target, numbers);
        
        return cnt;
    }
}