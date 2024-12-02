class Solution {
    // 자연수 n을 연속한 자연수 들로 표현하는 방법의 경우의 수를 따진다. 
    public int solution(int n) {
        int answer = 0;
        // O(N^2)의 시간이 발생을 한다. 10,000 x 10,000 -> 1억번 수행..
        // i= 연속한 자연수들의 시작점 
        for(int i=1;i<=n;i++) {
            int sum = 0;
            // j= 연속한 자연수 들
            for(int j=i;j<=n;j++) {
                sum += j;
                if(sum > n) {
                    break;
                }
                // 연속한 자연수로 n을 만들 수 있다면 
                if(sum == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}