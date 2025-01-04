class Solution {
    /* 7 8 9
    *. 4 5 6
       1 2 3
       위,아래 뒤집고 -> i,j 를 j,i로 바꾸면 90도 회전 
       7 4 1
       8 5 2 
       9 6 3
    */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 1. 위, 아래 뒤집기 i -> n-1-i (단, 아래를 반만 처리)
        for(int i=0;i<n/2;i++) {
            for(int j=0;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        // 2. i,j 를 j,i로 바꾸기 (단, j를 i 값 이상(\)부터만 처리)
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}