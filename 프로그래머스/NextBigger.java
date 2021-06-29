package programmers.example;
/*
문제: 다음 큰 숫자
유형: 완전 탐색, 바이너리
날짜: 2021.06.29 (화)
 */
public class NextBigger {
    public static void main(String[] args) {
        int n = 78;
        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n);
        int nCnt = 0;
        for(int i=0;i<nBinary.length();i++){
            if(nBinary.charAt(i) == '1'){
                nCnt += 1;
            }
        }
        int next = n+1;
        // 백만 이하일 때까지만
        while(next <= 2000000){
            String nextBinary = Integer.toBinaryString(next);
            int nextCnt = 0;
            for(int i=0;i<nextBinary.length();i++){
                if(nextBinary.charAt(i) == '1'){
                    nextCnt += 1;
                }
            }
            if(nCnt == nextCnt){
                return next;
            }
            else{
                next += 1;
            }
        }
        return answer;
    }
}
