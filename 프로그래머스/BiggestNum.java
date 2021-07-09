package programmers.example;

import java.util.*;
/*
문제 : 가장 큰 수
유형 : 정렬
날짜 : 2021.07.09 (금)
 */

public class BiggestNum {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numStr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            numStr[i] = String.valueOf(numbers[i]);
        }
        // 내림차순 정렬 (앞+뒤와 뒤+앞을 비교)
        Arrays.sort(numStr, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        });
        // [0,0] 케이스
        if(numStr[0].equals("0")) {
            return "0";
        }

        for(String item : numStr) {
            answer = answer + item;
        }
        return answer;
    }
}