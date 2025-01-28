class Solution {
    public int minDistance(String word1, String word2) {
        //   x h o r s e 
        // x 0 1 2 3 4 5
        // r 1 1 2 2 3 4
        // o 2 2 1 2 3 4
        // s 3 3 2 3 2 3

        // 최소 편집 거리 알고리즘 
        // dp[i][j] : 문자열 a의 i번째 - b의 j번째까지의 둘 사이 최소 편집 거리 
        // 1) 같을 때 : dp[i][j] = dp[i-1][j-1]
        // 2) 다를 때 : dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];

        // dp 배열 0번째 i,j 세팅
        for(int i=1; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int j=1; j<=m; j++) {
            dp[0][j] = j;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                // 문자가 같음 -> 그대로 
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // 문자가 다름
                else {
                    // 치환 / 삭제 / 수정 
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }

        return dp[n][m];
    }
}