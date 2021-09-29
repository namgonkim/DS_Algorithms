class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int bigW = 0;
        int bigH = 0;
        for(int i=0;i<sizes.length;i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];
            if(w < h) {
                int temp = w;
                w = h;
                h = temp;
            }
            if(bigW < w) {
                bigW = w;
            }
            if(bigH < h) {
                bigH = h;
            }
        }
        answer = bigW * bigH;
        return answer;
    }
}