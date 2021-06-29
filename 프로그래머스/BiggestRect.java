package programmers.example;
/*
문제: 가장 큰 정사각형
유형: DP, 구현
날짜: 2021.06.29 (화)
 */
public class BiggestRect {
    public static void main(String[] args) {
        // [[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]	9
        // [[0,0,1,1],[1,1,1,1]]	4
        int[][] board = {
                {0,0,1,1},
                {1,1,1,1}
        };
        int answer = solution(board);
        System.out.println(answer);

    }
    public static int solution(int [][]board)
    {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        // 맨 위에가 배열 범위를 벗어나지 않게 + 1 적용
        int[][] map = new int[r + 1][c + 1];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                map[i+1][j+1] = board[i][j];
            }
        }
        // 0,0 -> 1,1임을 생각하고 풀이
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                // 왼쪽, 위, 왼쪽 대각선 위에서 내려온 map[i][j]를 기준으로 세개의 값 중에 최소값 + 1을 적용
                if(map[i][j] != 0){
                    // dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j]) + 1
                    map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1])) + 1;
                    // 가장 큰 값을 적용
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        answer = answer * answer;
        return answer;
    }
}
