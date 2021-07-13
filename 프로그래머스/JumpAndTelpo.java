package programmers.summerwinter;
/*
문제 : 점프와 순간이동
유형 : 구현
날짜 : 2021.07.13 (화)
 */
public class JumpAndTelpo {

    public int solution(int n) {
        int answer = 0;

        while(n != 0) {
            if(n % 2 != 0) {
                answer += 1;
                n -= 1;
            }
            else {
                n = n / 2;
            }
        }

        return answer;
    }
}
