package kakao;

import java.util.ArrayList;
/*
문제: 2018 카카오 공채
유형: 구현( multiset 합집합, 교집합 )
날짜: 2021.06.25
 */

public class Solution_k {
    public static int solution(String str1, String str2) {
        // 소문자 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // 두 배열 생성
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        // 각 배열 쌍 조합 구하기(소문자만 취급)
        String temp = "";
        for(int i=0;i<str1.length()-1;i++){
            temp = temp + str1.charAt(i) + "" + str1.charAt(i+1) + "";
            if((97 <= str1.charAt(i) && str1.charAt(i) <= 122) && (97 <= str1.charAt(i+1) && str1.charAt(i+1) <= 122)) {
                list1.add(temp);
            }
            temp = "";
        }
        for(int i=0;i<str2.length()-1;i++) {
            temp = temp + str2.charAt(i) + "" +str2.charAt(i+1) + "";
            if((97 <= str2.charAt(i) && str2.charAt(i) <= 122) && (97 <= str2.charAt(i+1) && str2.charAt(i+1) <= 122)) {
                list2.add(temp);
            }
            temp = "";
        }
        // 합집합, 교집합 구하기
        int inter = 0;
        for(String item : list1){
            String walk = item;
            for(String finder : list2){
                if(walk.equals(finder)){
                    list2.remove(finder);
                    inter+=1;
                    break;
                }
            }
        }
        int union = list1.size() + list2.size();
        // 결과 = 합집합 / 교집합 * 65536 [먼저 소수로 구하고 곱한 값을 정수로 변환]
        int res = 0;
        if(union == 0 && inter == 0) res = 1;
        else res = (int)(((double) inter / union) * 65536);

        return res;
    }

    public static void main(String[] args) {
        //E=M*C^2	e=m*c^2
        // aa1+aa2	AAAA12
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        int answer = solution(str1, str2);
        System.out.println(answer);
    }
}
