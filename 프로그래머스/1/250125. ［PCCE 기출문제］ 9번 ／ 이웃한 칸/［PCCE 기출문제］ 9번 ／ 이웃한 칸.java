class Solution {
    public static int n;
    public static int[] dh = {0, 1, -1 ,0};
    public static int[] dw = {1, 0 ,0, -1};
    
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        // 변수 초기화
        n = board.length;
        // 4방향 탐색 
        for(int i=0;i<4;i++) {
            int h_check = h+dh[i];
            int w_check = w+dw[i];
            
            if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                // 방향에 같은 색이 있으면 카운트
                // eqauls() -> 동등성(같은 값을 가지는지)으로 판단한다.
                if(board[h_check][w_check].equals(board[h][w])) {
                    count++;
                }
            }
        }
        return count;
    }
}