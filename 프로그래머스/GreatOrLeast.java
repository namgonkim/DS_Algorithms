package programmers.example;

import java.util.Arrays;

/*
문제: 최대값 혹은 최소값
유형: 구현
날짜: 2021.06.28 (월)
 */
public class GreatOrLeast {
    public static void main(String[] args) {

    }
    public static String solution(String s) {
        String answer = "";
        String[] log = s.split(" ");
        int[] arr = new int[log.length];
        for(int i=0;i<log.length;i++){
            arr[i] = Integer.parseInt(log[i]);
        }
        Arrays.sort(arr);
        answer = answer + String.valueOf(arr[0]) + " ";
        answer = answer + String.valueOf(arr[arr.length-1]);
        return answer;
    }
}
