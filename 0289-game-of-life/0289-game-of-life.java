class Solution {
    // 한번의 과정으로 갱신 되어야 함 -> 변경된 상태가 board에 남아있으면 안된다. 
    public int m;
    public int n;
    // 상 하 좌 우 대각 
    public int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
    public int[] dx = {0, 0, 1, -1, -1, 1, 1, -1};

    public void gameOfLife(int[][] board) {
        m = board[0].length;
        n = board.length;

        int[][] reflect = new int[n][m];

        // 변경한 상태 기록하기 
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                reflect[i][j] = run(i, j, board);
            }
        }
        // 변경된 상태로 보드 덮어쓰기 
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                board[i][j] = reflect[i][j];
            }
        }
        
    }
    // 1. 1 셀 주변에 1이 2개 미만이면 0
    // 2. 1 셀 주변에 2-3개가 1이면 1 
    // 3. 1 셀 주변에 3개 초과해 1이면 0 
    // 4. 0 셀 주변에 3개가 1이면 1 
    // if(1셀 < 2 || 1셀 > 3) 0
    // if(1셀 == 2) now
    // if(1셀 == 3) 1
    public int run(int y, int x, int[][] board) {
        int count = 0;
        for(int i=0;i<8;i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if(board[ny][nx] == 1) {
                    count+=1;
                }
            }
        }
        
        if(count == 2) {
            return board[y][x];
        }
        else if(count == 3) {
            return 1;
        }
        return 0;
    }
}