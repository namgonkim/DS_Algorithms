package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
문제: 문자열 폭발
유형: 문자열, 스택
날짜: 2021.07.22 (목)
설명: 주어진 문자열1에서 문자열2가 포함되어 있으면 폭발(삭제)을 진행한다. 폭발하면 문자열1에서 문자열2가 사라지며, 남은 문자열은 합쳐진다. 이 과정을 반복해 남아있는 문자열을 찾고, 없다면 FRULA를 출력한다.

풀이 방법
1. 스택을 이용
2. StringBuilder를 이용 - 선택

풀이
indexOf()와 replace()혹은 delete()를 활용해 전체 문자열에서 부분 문자열을 지워주는 방식으로 구현했었다가 메모리 초과가 발생했다.
따라서 문자열을 하나씩 추가해주며 탐색을 진행하는데 폭발할 문자열이 삽입되었다면 삭제해주었다.
 */

public class Main9935 {

    public String solution(String s, String t) {
        String answer = "";
        // replace , replaceAll -> 용량을 많이 먹어서 메모리 초과
        int slen = s.length();
        int tlen = t.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<slen;i++) {
            char word = s.charAt(i);
            sb.append(word);

            // 현재까지 이어진 문자열이 폭발 문자열 보다 크거나 같아지면 검사를 시작(폭발할 문자열이 있는지)
            if(sb.length() >= tlen) {

                boolean isBoom = true;
                for(int finder=0;finder<tlen;finder++) {
                    // 새롭게 들어온 문자 및 문자열에 대해 추적
                    int walker = sb.length() - tlen;
                    // 문자열 내 문자가 다르다면 종료
                    if(sb.charAt(walker + finder) != t.charAt(finder)) {
                        isBoom = false;
                        break;
                    }
                }
                // 문자열 폭발을 해야한다면
                if(isBoom == true) {
                    sb.delete(sb.length() - tlen, sb.length());
                }
            }
        }
        if(sb.length() == 0){
            return "FRULA";
        } else {
            answer = sb.toString();
            return answer;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        Main9935 main = new Main9935();

        System.out.println(main.solution(s,t));
    }
}
