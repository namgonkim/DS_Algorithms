package programmers.example;
/*
문제: 숫자의 표현
설명: 주어진 n의 숫자에서 1~n까지 연속된 숫자들을 더했을 때 n이 될 수 있는 경우의 수 찾기
유형: 완전탐색
날짜: 2021.06.29 (화)
 */
public class ExpressionNumber {
    public static void main(String[] args) {
        int n = 15;
        int answer = solution(n);
        System.out.println(answer);

    }
    public static int solution(int n) {
        int answer = 0;
        int dp = 1, cnt = 0;
        // dp값부터 더해보며 순회 n이 되는 순간과 그것보다 더 커지는 순간으로 파악
        for(int i=dp;i<=n;i++){
            cnt = cnt + i;
            // 지금까지 연속된 숫자를 더했을 때 n이 되는 경우
            if(cnt == n) {
                // 다음 수를 기준으로 연속된 숫자 파악
                answer += 1; // 카운터 증가
                dp += 1;     // 다음수 체킹
                i = dp - 1;  // dp - 1
                cnt = 0;     // 덧셈 초기화
            }
            // 연속된 숫자를 더했을 때 n보다 클 경우
            else if(cnt > n){
                // 합이 안된다. 초기화 후 다음 연속 시작 수 변경.
                dp += 1;
                i = dp - 1;
                cnt = 0;
            }
        }
        return answer;
    }
}
