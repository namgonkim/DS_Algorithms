package programmers.example;

/*
문제: JadenCase 형식의 문자열로 변환하기
유형: 문자열/구현
날짜: 2021.06.28 (월)
 */

import java.util.Arrays;

public class JadenCase {
    public static void main(String[] args) {
        //"3people unFollowed me"	"3people Unfollowed Me"
        //"for the last week"	"For The Last Week"
        String s = "3people unFollowed me";
        String answer = solution(s);
        System.out.println(answer);
    }
    public static String solution(String s) {
        String answer = "";
        String temp = s.charAt(0) + "";
        answer = answer + temp.toUpperCase();
        for(int i=1;i<s.length();i++){
            String now = s.charAt(i) + "";
            if(now.equals(' ')) { // 공백이면 함께 공백처리해주기
                answer = answer + " ";
            }
            else if(s.charAt(i-1) == ' ') { // 전 문자열이 공백이었다면 대문자
                answer = answer + now.toUpperCase();
            }
            else { // 소문자
                answer = answer + now.toLowerCase();
            }
        }
        return answer;
    }
}
