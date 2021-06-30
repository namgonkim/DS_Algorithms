package kakao.blind2018;

/*
문제: N진수 게임
유형: 구현
날짜: 2021.06.30 (수)
 */

class Solution1 {
    public static void main(String[] args) {
        //  n	t	m	p	result
        //  2	4	2	1	"0111"
        //  16	16	2	1	"02468ACE11111111"
        //  16	16	2	2	"13579BDF01234567"
        Solution1 s1 = new Solution1();
        System.out.println(s1.solution(16,16,2,2));
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";
        // 이 게임에서 나올 전체 숫자 문자열
        String total_str = "0";
        int count = 0;
        // 전체 숫자 문자열이 (인원*구할 문자의 개수 + 튜브의 순서) 보다 작을때까지
        while(total_str.length() < (m*t)+p){
            String record = ""; // 문자 저장
            int num = count++;  // 진법 계산

            while(num != 0) {
                // n이 10진법 이상일 경우, 문자 + 55를 통해 A,B .. 로 변경
                if(num % n >= 10) {
                    record += String.valueOf((char) (num%n + 55));
                }
                else{
                    record += String.valueOf(num%n);
                }
                // 나눗셈
                num = num / n;
            }
            // 진법으로 저장된 건 큰수부터 저장되어 있으니까 이걸 반대로 뒤집어 줘야함
            total_str = total_str + new StringBuffer(record).reverse().toString();

        }

        for(int i=0;i<t; i++){
            // 참가 인원*말해야하는 i번째 횟수 + 튜브의 순서-1
            answer = answer + String.valueOf(total_str.charAt(i*m + p-1));
        }

        return answer;
    }
}