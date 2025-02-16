class Solution {
    
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        // 맨 아래 바로 위에서부터 위로 거슬러 올라가면서 
        // 아랫칸으로 갈 수 있는 길의 덧셈 중 더 큰 값을 현재 값으로 치환 
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}