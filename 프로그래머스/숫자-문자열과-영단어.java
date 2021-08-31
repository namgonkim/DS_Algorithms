/*
문제: 숫자 문자열과 영단어
유형: 카카오 채용연계 2021, 구현
날짜: 2021 08 31 화
*/

class Solution {
    public static String[] numbers =
            {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static int solution(String s) {
        int answer = 0;
        StringBuffer sb = new StringBuffer(s);
        for(int i=0;i<numbers.length;i++) {
            int ret = s.indexOf(numbers[i]);
            if(ret != -1) {
                s = s.replace(numbers[i], String.valueOf(i));
            }
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}