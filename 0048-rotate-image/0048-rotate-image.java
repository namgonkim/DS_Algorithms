class Solution {
    // matrix 이외에 추가 배열을 선언하지 말고 90도 시계방향으로 회전시키기 
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 위 아래를 변경 
        for(int i=0;i<n/2;i++) {
            for(int j=0;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        // 대각선으로 변경 
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}