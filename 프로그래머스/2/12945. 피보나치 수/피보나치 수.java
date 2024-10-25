class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int answer = 0;
        for(int i=2;i<=n;i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567; 
        }
        answer = dp[n];
        return answer;
    }
}