class Solution {
    // 모든 명함의 가로,세로 길이가 있는 2차원 배열을 가지고 
    // 명함 지갑의 크기를 최소화할 수 있는 방법 
    // 1. 가로 세로 중 긴 친구를 가로로 밀어넣는다.
    // 2. 가로 최대 길이와 세로 최대 길이를 찾는다.
    public int solution(int[][] sizes) {
        int row = 0;
        int col = 0;
        for(int[] size : sizes) {
            if(size[0] < size[1]) {
                int temp = size[1];
                size[1] = size[0];
                size[0] = temp;
            }
        }
        for(int[] size : sizes) {
            row = Math.max(row, size[0]);
            col = Math.max(col, size[1]);
        }
        int answer = row*col;
        return answer;
    }
}