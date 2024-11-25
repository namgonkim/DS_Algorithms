class Solution {
        public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // DP로 문제를 푼다
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                dp[i][j] = 0;
            }
        }
        // 점화식
        // 현재 좌표 기준으로 위, 왼쪽, 대각선 위 좌표들이 정사각형을 이루고 있다면 내 좌표를 포함해 더 큰 정사각형을 그릴 수 있어 그 값을 더해나가면 된다.
        // dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
        int answer = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                // matrix[i][j]가 1일때만
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer * answer;
    }
}