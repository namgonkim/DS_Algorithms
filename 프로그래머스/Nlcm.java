package programmers.example;

/*
문제: 배열의 최소공배수 구하기
유형: 최대공약수/최소공배수 (유클리드 호재법)
날짜: 2021.06.28
 */

public class Nlcm {

    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        int answer = solution(arr);
        System.out.println(answer);
    }

    // gcd: 두 수의 최대 공약수
    public static int gcd(int a, int b){
        while(b != 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        // lcm = 두 수의 곱/두 수의 최대 공약수
        int lcm = (a*b) / gcd(a,b);
        return lcm;
    }

    public static int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1;i<arr.length;i++){
            answer = lcm(answer,arr[i]);
        }

        return answer;
    }

}
